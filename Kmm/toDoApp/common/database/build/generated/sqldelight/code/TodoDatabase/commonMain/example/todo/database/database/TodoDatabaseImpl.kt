package example.todo.database.database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import example.todo.common.database.TodoDatabaseQueries
import example.todo.common.database.TodoItemEntity
import example.todo.database.TodoDatabase
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.jvm.JvmField
import kotlin.reflect.KClass

internal val KClass<TodoDatabase>.schema: SqlDriver.Schema
  get() = TodoDatabaseImpl.Schema

internal fun KClass<TodoDatabase>.newInstance(driver: SqlDriver): TodoDatabase =
    TodoDatabaseImpl(driver)

private class TodoDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), TodoDatabase {
  public override val todoDatabaseQueries: TodoDatabaseQueriesImpl = TodoDatabaseQueriesImpl(this,
      driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE IF NOT EXISTS TodoItemEntity (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    orderNum INTEGER NOT NULL,
          |    text TEXT NOT NULL,
          |    isDone INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class TodoDatabaseQueriesImpl(
  private val database: TodoDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), TodoDatabaseQueries {
  internal val selectAll: MutableList<Query<*>> = copyOnWriteList()

  internal val select: MutableList<Query<*>> = copyOnWriteList()

  internal val getLastInsertId: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> selectAll(mapper: (
    id: Long,
    orderNum: Long,
    text: String,
    isDone: Boolean
  ) -> T): Query<T> = Query(118138038, selectAll, driver, "TodoDatabase.sq", "selectAll", """
  |SELECT *
  |FROM TodoItemEntity
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!! == 1L
    )
  }

  public override fun selectAll(): Query<TodoItemEntity> = selectAll { id, orderNum, text, isDone ->
    TodoItemEntity(
      id,
      orderNum,
      text,
      isDone
    )
  }

  public override fun <T : Any> select(id: Long, mapper: (
    id: Long,
    orderNum: Long,
    text: String,
    isDone: Boolean
  ) -> T): Query<T> = SelectQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!! == 1L
    )
  }

  public override fun select(id: Long): Query<TodoItemEntity> = select(id) { id_, orderNum, text,
      isDone ->
    TodoItemEntity(
      id_,
      orderNum,
      text,
      isDone
    )
  }

  public override fun getLastInsertId(): Query<Long> = Query(439915985, getLastInsertId, driver,
      "TodoDatabase.sq", "getLastInsertId", "SELECT last_insert_rowid()") { cursor ->
    cursor.getLong(0)!!
  }

  public override fun add(text: String): Unit {
    driver.execute(-287991022, """
    |INSERT INTO TodoItemEntity (orderNum, text)
    |VALUES ((CASE (SELECT COUNT(*) FROM TodoItemEntity) WHEN 0 THEN 1 ELSE (SELECT MAX(orderNum)+1 FROM TodoItemEntity) END), ?)
    """.trimMargin(), 1) {
      bindString(1, text)
    }
    notifyQueries(-287991022, {database.todoDatabaseQueries.selectAll +
        database.todoDatabaseQueries.select})
  }

  public override fun setText(text: String, id: Long): Unit {
    driver.execute(-1065617760, """
    |UPDATE TodoItemEntity
    |SET text = ?
    |WHERE id = ?
    """.trimMargin(), 2) {
      bindString(1, text)
      bindLong(2, id)
    }
    notifyQueries(-1065617760, {database.todoDatabaseQueries.selectAll +
        database.todoDatabaseQueries.select})
  }

  public override fun setDone(isDone: Boolean, id: Long): Unit {
    driver.execute(-1066085131, """
    |UPDATE TodoItemEntity
    |SET isDone = ?
    |WHERE id = ?
    """.trimMargin(), 2) {
      bindLong(1, if (isDone) 1L else 0L)
      bindLong(2, id)
    }
    notifyQueries(-1066085131, {database.todoDatabaseQueries.selectAll +
        database.todoDatabaseQueries.select})
  }

  public override fun delete(id: Long): Unit {
    driver.execute(1891271066, """
    |DELETE FROM TodoItemEntity
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id)
    }
    notifyQueries(1891271066, {database.todoDatabaseQueries.selectAll +
        database.todoDatabaseQueries.select})
  }

  public override fun clear(): Unit {
    driver.execute(-1879375746, """DELETE FROM TodoItemEntity""", 0)
    notifyQueries(-1879375746, {database.todoDatabaseQueries.selectAll +
        database.todoDatabaseQueries.select})
  }

  private inner class SelectQuery<out T : Any>(
    @JvmField
    public val id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(select, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-1974259477, """
    |SELECT *
    |FROM TodoItemEntity
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id)
    }

    public override fun toString(): String = "TodoDatabase.sq:select"
  }
}
