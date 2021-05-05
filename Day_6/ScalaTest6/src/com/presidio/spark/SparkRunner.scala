package com.presidio.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkRunner {

  def main(args:Array[String]): Unit ={

    val sparkConf = new SparkConf()
    sparkConf.setAppName("DataJob");
    sparkConf.setMaster("local[*]")

    val sparkContext = new SparkContext(sparkConf)

    val textFileRDD = sparkContext.textFile("/Users/umeshmoorthy/scala/testData/auth.csv")

    textFileRDD.foreach(each => println(each))

    sparkContext.stop()

  }

}
