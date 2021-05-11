package com.presidio.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkRunner {

  def main(args: Array[String]): Unit = {

    /*
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("spark://Umeshs-MacBook-Pro.local:7077")
    val sparkContext = new SparkContext(sparkConf)
   //val textFileRDD = sparkContext.textFile("/Users/umeshmoorthy/scala/testData/auth.csv")
    val textFileRDD = sparkContext.textFile("hdfs://localhost:9000/testData/auth.csv")
    */

    // for docker jar
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("spark://eb0988bbd19c:7077")
    val sparkContext = new SparkContext(sparkConf)
    //val textFileRDD = sparkContext.textFile("/Users/umeshmoorthy/scala/testData/auth.csv")
    val textFileRDD = sparkContext.textFile("/usr/bin/bd/fs/data/auth.csv")

    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      println(columns(3))
      (columns(3), columns(5))
    })

    val filteredRDD = mappedRDD.filter(each => !each._1.equals("740000"))

    //val collectedElements = textFileRDD.collect()
    //collectedElements.foreach(c => println(c.split(",")(0)))

    sparkContext.stop()

  } //

}
