package com.presidio.designpatterns.interpreter

class Number(n: Int) extends Expression {
  override def interpret(): Int = n
}
