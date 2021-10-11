package com.presidio.designpatterns.interpreter

class Interpreter {
  def interpret(expression: Expression): Int = expression.interpret()
}
