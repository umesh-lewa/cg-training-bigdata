package com.presidio.tansformations

class DropFilterTransformation {

  def doDropFilter(data:List[String]): Unit ={

    println("========== Drop Filter Transformation ==========")
    data.drop(3).foreach { x => println(x) }

  }

}
