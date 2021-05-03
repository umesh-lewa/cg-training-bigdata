package com.presidio.functions

class VarriableArgumentsFunction {

  def varArgFunc(args : String*) : Unit = {
    for (i <- args)
      println(i)
  }

}
