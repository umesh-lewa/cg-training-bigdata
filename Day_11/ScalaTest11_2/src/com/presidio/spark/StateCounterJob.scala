package com.presidio.spark

import org.apache.spark.sql.SparkSession

object StateCounterJob {

  def main(args : Array[String]) = {
    //M
    val ss= SparkSession.builder()
      .appName("StateCounterJob")
      .master("local[*]")
      .getOrCreate()
    // States - Replace the state name with the state code using broadcast
    // Rajasthan - RH
    // M
    val sc = ss.sparkContext
    // W
    val textRDD = sc.textFile("auth.csv")
    val states = Map( ("Rajasthan","RH"),
      ("Andhra","AN"),
      ("TamilNadu","TN"))
    val broadcastStates = sc.broadcast(states)
    // W
    val resStateColumnRDD = textRDD.map(each => each.split(",")(128))
    // W
    val accumulatorCalculationRDD = resStateColumnRDD.map(each => {
      if (each.equals("Rajasthan")) {
        broadcastStates.value.get("Rajasthan")
      }
      if (each.equals("Andhra")) {
        broadcastStates.value.get("Andhra")
      }
    })
    // M/W - result to the master
    accumulatorCalculationRDD.foreach(each => println(each))
  }

}
