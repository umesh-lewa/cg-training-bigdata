package com.presidio.dataprocessing

import com.coda.dataprocessing.DataProcesingReckoner

object DataJob {

  def main(args: Array[String]): Unit ={

    val dataList = List("","","",12)
    val dataSet = Set("","","","")
    dataSet.foreach(each => print(each))

    val dataTuple = ("","","")
    val dataMap = Map(1 -> "value1","key2" -> "value2")
    dataMap.foreach(each => println(each._1))
    dataMap.foreach(each => println(each._2))

    val dataProcessing = new DataProcesingReckoner()
    dataProcessing.compute("some data")
  }
}
