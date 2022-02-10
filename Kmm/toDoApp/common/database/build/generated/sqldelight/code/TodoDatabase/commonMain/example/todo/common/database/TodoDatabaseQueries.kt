package example.todo.common.database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface TodoDatabaseQueries : Transacter {
  public fun <T : Any> selectAll(mapper: (
    id: Long,
    orderNum: Long,
    text: String,
    isDone: Boolean
  ) -> T): Query<T>

  public fun selectAll(): Query<TodoItemEntity>

  public fun <T : Any> select(id: Long, mapper: (
    id: Long,
    orderNum: Long,
    text: String,
    isDone: Boolean
  ) -> T): Query<T>

  public fun select(id: Long): Query<TodoItemEntity>

  public fun getLastInsertId(): Query<Long>

  public fun add(text: String): Unit

  public fun setText(text: String, id: Long): Unit

  public fun setDone(isDone: Boolean, id: Long): Unit

  public fun delete(id: Long): Unit

  public fun clear(): Unit
}
