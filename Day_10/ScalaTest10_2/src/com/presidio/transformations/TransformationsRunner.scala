package com.presidio.transformations

import org.apache.spark.sql.SparkSession

object TransformationsRunner {

  def main(args:Array[String]): Unit ={

    println("hello world")

    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("spark://Umeshs-MacBook-Pro.local:7077")
      .getOrCreate()

    println("spark session works with local spark master")

    val authDF = ss.read
      .option("header",true)
      .csv("/Users/umeshmoorthy/bigData/scala/testData/auth.csv")

    println("auth data frame works")

    authDF.createOrReplaceTempView("AUTH_TABLE")
    val authState = ss.sql("SELECT RES_STATE_NAME FROM AUTH_TABLE")
    val distinctAuthState = authState.distinct();
    distinctAuthState.show()

    println("auth data frame distinct works")

    /*
    val serviecCon  = ss.sparkContext
      .textFile("/Users/umeshmoorthy/bigData/scala/testData/auth.csv")
      .filter(param => param.split(",")(3).toString.equals("SERVICEMON"))

    println("spark context works")

    val NSDLSA0011Con = ss.sparkContext
      .textFile("/Users/umeshmoorthy/bigData/scala/testData/auth.csv")
      .filter(param => param.split(",")(3).toString.equals("NSDLSA0011"))
    */

    /*
    val saAndAuaData = serviecCon.cartesian(NSDLSA0011Con).foreach(param => println(param._1 + " ---> " + param._2))

    println("cartesian works")
     */

  }

}
