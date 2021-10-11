package com.presidio.designpatterns.interpreter

class Multiplication(right: Expression, left: Expression) extends Expression {
  override def interpret(): Int= {
    left.interpret()*right.interpret()
  }
}
