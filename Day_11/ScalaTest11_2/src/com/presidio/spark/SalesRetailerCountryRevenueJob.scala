package com.presidio.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object SalesRetailerCountryRevenueJob {

  def main(args:Array[String]): Unit ={

    val ss = SparkSession .builder()
      .appName("SalesRetailCountryRevenueJOB")
      .master("spark://Umeshs-MacBook-Pro.local:7077")
      .getOrCreate()

    println("spark session works with local spark master")

    val sc = ss.sparkContext

    //val countryRevenueAccumulator = sc.longAccumulator("CountryRevenueAccumulator")

    val salesDF1 = ss.read
      .option("header",true)
      .csv("hdfs://localhost:9000/testData/sales1.csv")

    val salesDF2 = ss.read
      .option("header",true)
      .csv("hdfs://localhost:9000/testData/sales2.csv")

    println("sales data frame works")

    salesDF1.createOrReplaceTempView("SALES_TABLE_1")

    salesDF2.createOrReplaceTempView("SALES_TABLE_2")

    //val authState = ss.sql("SELECT * FROM SALES_TABLE_1")

    val franceRevenueDF = ss.sql("SELECT SALES_TABLE_1.`Retailer country`, SALES_TABLE_2.Revenue" +
      " FROM SALES_TABLE_1 FULL OUTER JOIN SALES_TABLE_2 ON SALES_TABLE_1.`Retailer country` = SALES_TABLE_2.`Retailer country`" +
      " WHERE SALES_TABLE_1.`Retailer country` = 'France'")

    //val distinctAuthState = authState.distinct();
    //distinctAuthState.show()

    franceRevenueDF.show(100)

    println("Filter null revenue")

    //franceRevenue.filter("Revenue is not null").show(100)
    //val temp = franceRevenue.groupBy("Retailer country").sum("Revenue").show()

    var sum : Long = 0

    franceRevenueDF.withColumn("Revenue",col("Revenue").cast("integer"))
    franceRevenueDF.collect()

    val temp = franceRevenueDF.groupBy("Retailer country").sum("Revenue").show()

    /*
    franceRevenueDF.foreach(row => {

      var name = row.mkString(",").split(",")(0)
      var revenue = row.mkString(",").split(",")(1)

      //println("revenue : "+revenue)
      //sum += revenue.toFloat
      countryRevenueAccumulator.add(revenue.toLong)
    })
     */
    /*
    for (row <- franceRevenue.rdd.collect){

    }
     */

    println("temp : "+temp)

    println("sales data frame")

    //println("countryRevenueAccumulator : "+countryRevenueAccumulator.value)
  }

}
