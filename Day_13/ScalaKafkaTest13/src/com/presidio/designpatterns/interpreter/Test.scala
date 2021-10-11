package com.presidio.designpatterns.interpreter

object Test{

  def main(args: Array[String]): Unit = {

    val expr1 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
    val parser = new Parser
    val interpreter = new Interpreter
    println(interpreter.interpret(parser.parse(expr1)))

  }

}
