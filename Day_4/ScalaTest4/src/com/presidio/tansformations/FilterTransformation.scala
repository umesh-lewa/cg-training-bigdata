package com.presidio.tansformations

class FilterTransformation {

  def doFilter(data:List[String],startsWithFilter:String): Unit ={

    println("========== Filter Transformation ==========")
    data. filter { x => x.startsWith(startsWithFilter) }.foreach { x => println(x) }

  }

}
