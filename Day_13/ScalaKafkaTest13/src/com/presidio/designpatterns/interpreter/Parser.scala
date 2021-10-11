package com.presidio.designpatterns.interpreter

class Parser {
  // val expr1 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
  def parse(expression: String): Expression =
  {
    var tokenizer = expression.split(" ")
    tokenizer.foldLeft(scala.collection.mutable.Stack[Expression]()) {
      case (result, token) =>
        val item = ExpressionFactory(token.toString, result.pop(), result.pop())
        item.foreach(result.push)
        result
    }.pop()
  }
}