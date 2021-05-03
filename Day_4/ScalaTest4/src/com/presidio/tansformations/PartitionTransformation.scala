package com.presidio.tansformations

class PartitionTransformation {

  def doPartitionFilter(data:List[String],startsWithFilter:String): Unit ={

    println("========== Partition Transformation ==========")
    val partitionedData = data.partition(data=>data.startsWith(startsWithFilter))
    partitionedData._1.foreach(x=>println(x))
    partitionedData._2.foreach(x=>println(x))

  }

}
