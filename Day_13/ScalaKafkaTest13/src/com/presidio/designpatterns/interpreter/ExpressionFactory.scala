package com.presidio.designpatterns.interpreter

object ExpressionFactory {
  def apply(operator: String, left: => Expression, right: => Expression): Option[Expression] = operator match {
      case "+" => Some(new Addition(right, left))
      case "-" => Some(new Substraction(right, left))
      case "*" => Some(new Multiplication(right, left))
      case i if i.matches("\\d+") => Some(new Number(i.toInt))
      case _ => None
    }
}
