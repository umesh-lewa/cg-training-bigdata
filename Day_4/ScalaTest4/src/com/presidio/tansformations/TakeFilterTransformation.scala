package com.presidio.tansformations

class TakeFilterTransformation {

  def doTakeFilter(data:List[String]): Unit ={

    println("========== Take Filter Transformation ==========")
    data.take(3).foreach { x => println(x) }

  }

}
