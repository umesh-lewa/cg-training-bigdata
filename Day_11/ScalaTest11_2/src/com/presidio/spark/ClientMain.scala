package com.presidio.spark

import org.apache.spark.sql.SparkSession

object ClientMain {

  // Job - DriverProgram - Stage - Task
  // Dataframe is also immutable in nature
  // Accumulator / Broadcast
  def main(args : Array[String]) = {

    // master
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

    // How many number of authentication rows are there for the State = Karnataka
    // using accumulator


    // master
    val sc = ss.sparkContext

    // master
    val sharedAccumulator = sc.longAccumulator("SharedAccumulator")

    // worker
    val textFileRDD = sc.textFile("hdfs://localhost:9000/testData/auth.csv")

    // worker
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      println(columns(128),columns(129),columns(130),columns(131))
      if (columns(128).equals("Karnataka"))
        sharedAccumulator.add(1L)
    })

    // collected data will come to the master
    mappedRDD.collect()

    // master
    println("Total Count" + sharedAccumulator.value)
  }

}

