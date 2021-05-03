package com.presidio.tansformations

class HeadFilterTransformation {

  def doHeadFilter(data:List[String]){

    println("========== Head Filter Transformation ==========")
    data.head.foreach { x => println(x) }

  }

}
