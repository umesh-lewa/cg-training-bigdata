package com.presidio.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkRunner {

  def main(args : Array[String]) = {

    val sparkConf = new SparkConf()
    sparkConf.setAppName("DataJob")
    sparkConf.setMaster("local[*]")

    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/umeshmoorthy/scala/testData/auth.csv")

    //val countedElements = textFileRDD.count()
    //println(countedElements)

    //val firstElement = textFileRDD.first()
    //println("firstElement : "+firstElement)

    //val firstFiveElement = textFileRDD.take(5)
    //println("firstFiveElement : ")
    //firstFiveElement.foreach(each=>println(each))

    //val savedTextFile = textFileRDD.saveAsTextFile("/Users/umeshmoorthy/scala/savedObjects")

    //val savedObjectFile = textFileRDD.saveAsObjectFile("/Users/umeshmoorthy/scala/savedObjects")


    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(3), columns(5))
    })
    mappedRDD.foreach(each => println(each))

    sparkContext.stop()

  }

}
