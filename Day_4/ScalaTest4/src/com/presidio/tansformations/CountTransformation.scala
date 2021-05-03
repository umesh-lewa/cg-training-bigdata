package com.presidio.tansformations

class CountTransformation {

  def doCount(data:List[String],startsWithFilter:String): Unit ={

    println("========== Count Transformation ==========")
    val count = data.count(element => element.startsWith(startsWithFilter))
    println(count)

  }

}
