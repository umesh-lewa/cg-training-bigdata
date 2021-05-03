package com.presidio.tansformations

class MapTransformation {

  def doMap(data:List[String]): Unit ={

    println("========== Map Transformation ==========")
    data. map{data=>data.concat("_Country")}.foreach(x=>println(x))

  }

}
