package com.presidio.spark

import scala.collection.mutable._

import org.apache.spark.sql.SparkSession

object SalesProductTypeJob {

  def main(args:Array[String]): Unit ={

    //for the ProductLine=“Golf Equipment” how many ProductType are there

    val ss = SparkSession.builder()
      .appName("SalesProductTypeJob")
      .master("local[*]")
      .getOrCreate()

    //.master("spark://Umeshs-MacBook-Pro.local:7077")

    val sc = ss.sparkContext

    val sharedAccumulator = sc.longAccumulator("SharedAccumulator")

    //var productTypes : Set[String] = Set()
    //val productTypes = Set()

    //var productTypesList = new ListBuffer[String]()

    var productTypesArray = ArrayBuffer[String]()

    val textFileRDD = sc.textFile("hdfs://localhost:9000/testData/sales.csv")

    /*
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      //println(columns(1),columns(2),columns(3))
      if(columns(1).equals("Golf Equipment")){
        //productTypes += columns(2)
        println("Matched with golf")
        //productTypes.add(columns(2))
        //productTypesList += columns(2).toString
        productTypesArray+= columns(2)
      }
    })

    //val productTypes = productTypesList.toList
    //val uniqueProductTypes = productTypes.distinct

    val productTypes = productTypesArray.toList
    val uniqueProductTypes = productTypes.distinct


    mappedRDD.collect()
    */

    //println("Total ProductTypes : " + sharedAccumulator.value)

    //println("Total ProductTypes : " + uniqueProductTypes.size)
    //println("uniqueProductTypes : " + uniqueProductTypes.toString())

    textFileRDD.filter(each => {
      val productLine = each.split(",")(1)
      productLine.equals("Golf Equipment")
        })
      .map(each => {
      each.split(",")(2)
        })
      .distinct()
      .foreach(value => sharedAccumulator.add(1L))

    println("Product Types : "+sharedAccumulator.value)

  }

}
