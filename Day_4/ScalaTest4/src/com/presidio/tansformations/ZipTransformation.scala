package com.presidio.tansformations

class ZipTransformation {

  def doZipFilter(data:List[String],data2:List[String]): Unit ={

    println("========== Zip Transformation ==========")
    val zippedData = data.zip(data2)
    zippedData.foreach { x => println(x) }

  }

}
