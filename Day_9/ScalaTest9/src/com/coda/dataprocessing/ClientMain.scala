package com.coda.dataprocessing

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object ClientMain {

  // Dataframe is also immutable in nature
  def main(args : Array[String]) = {


    val ss = SparkSession.builder()
      .appName("CodaDataJOB")
      .master("spark://Umeshs-MacBook-Pro.local:7077")
      .getOrCreate()
    /*
    // Always write the function with a proper indentation
    val authDF = ss.read
      .option("header", "true")
      .csv("hdfs://localhost:9000/testData/auth.csv")

    //val auaASALicenseDF = authDF.select("aua", "sa", "license_id")

    //auaASALicenseDF.write.parquet("/Users/umeshmoorthy/scala/outData/parquet/")

    //auaASALicenseDF.write.orc("/Users/umeshmoorthy/scala/outData/orc/")

    //auaASALicenseDF.write.json("/Users/umeshmoorthy/scala/outData/json/")

    //auaASALicenseDF.write.csv("/Users/umeshmoorthy/scala/outData/csv/")

    val auaASALicenseDF = authDF.select("aua")
    auaASALicenseDF.write.text("/Users/umeshmoorthy/scala/outData/text/")

    auaASALicenseDF.show()
     */

    // read parquet
    /*
    val authDF = ss .read
      .option("header", "true")
      .parquet("/Users/dharshekthvel/ac")
    */


    // read csv
    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/umeshmoorthy/bigData/scala/testData/auth.csv")

    authDF.createOrReplaceTempView("AUTH_TABLE")

    //val auaASADF = ss.sql("SELECT AUA,ASA FROM AUTH_TABLE")
    val auaASADF = ss.sql("SELECT res_state_name, COUNT(*) FROM AUTH_TABLE GROUP BY res_state_name")
    println("========================== Query on AUTH_TABLE ================")
    auaASADF.show()
    println("========================== Query on AUTH_TABLE ================")


    // mapReduce step by step
    /*
    val sc = ss.sparkContext
    val textFileRDD = sc.textFile("hdfs://localhost:9000/testData/auth.csv")
    val flatMappedData = textFileRDD.flatMap(each => each.split(" "))
    val manualOneRDD = flatMappedData.map(each => (each,1))
    val finalOutputRDD = manualOneRDD.reduceByKey((x,y) => x+y)
    println("========================== MapReduce Step by Step ================")
    finalOutputRDD.foreach(println)
    println("========================== MapReduce Step by Step ================")
    */

    // mapReduce chain
    /*
    println("========================== MapReduce Chain ================")
    ss.sparkContext
      .textFile("hdfs://localhost:9000/testData/auth.csv")
      .flatMap(each => each.split(" "))
      .map(each => (each,1))
      .reduceByKey(_+_)
      .foreach(println)
    println("========================== MapReduce Chain ================")
    */
  }

}
