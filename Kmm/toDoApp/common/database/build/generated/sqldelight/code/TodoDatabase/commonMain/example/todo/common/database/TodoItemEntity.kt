package example.todo.common.database

import kotlin.Boolean
import kotlin.Long
import kotlin.String

public data class TodoItemEntity(
  public val id: Long,
  public val orderNum: Long,
  public val text: String,
  public val isDone: Boolean
) {
  public override fun toString(): String = """
  |TodoItemEntity [
  |  id: $id
  |  orderNum: $orderNum
  |  text: $text
  |  isDone: $isDone
  |]
  """.trimMargin()
}
