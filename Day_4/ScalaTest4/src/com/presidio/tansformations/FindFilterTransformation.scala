package com.presidio.tansformations

class FindFilterTransformation {

  def doFindFilter(data:List[String],startsWithFilter:String): Unit ={

    println("========== Find Filter Transformation ==========")
    data.find { x => x.startsWith(startsWithFilter) }.foreach { x => println(x) }

  }

}
