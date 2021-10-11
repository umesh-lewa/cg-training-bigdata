package com.presidio.designpatterns.interpreter

class Substraction(right: Expression, left: Expression) extends Expression {
  override def interpret(): Int= {
    left.interpret()-right.interpret()
  }
}
