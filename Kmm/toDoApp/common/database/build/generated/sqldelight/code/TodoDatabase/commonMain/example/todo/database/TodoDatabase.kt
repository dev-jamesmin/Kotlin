package example.todo.database

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import example.todo.common.database.TodoDatabaseQueries
import example.todo.database.database.newInstance
import example.todo.database.database.schema

public interface TodoDatabase : Transacter {
  public val todoDatabaseQueries: TodoDatabaseQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = TodoDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): TodoDatabase =
        TodoDatabase::class.newInstance(driver)
  }
}
