package com.presidio.case1

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.spark.sql.SparkSession

import java.util.Properties
import scala.io.Source

object AuthProducer {

  def main(args : Array[String]) = {

    /*
    Northern Trust has credit risk banking platform which publishes data in Kafka in the following topics.The platform is called VACE which is responsible for reporting data in FSB-IA and FINREP
    reports.
    [1] Write the scala producer to feed the data to NORTHERN-VACE topic from auth.csv. Read the auth.csv and feed it into the topic NORTHERN-VACE.
     */

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "PresidioProducer")
    //avroSerializer
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","445")
    props.put("compression.codec","1")
    props.put("request.required.acks","-1")
    //props.put("partitioner.class", "com.presidio.datascience.fileprocessing.KafkaUserCustomPartitioner")

    val producer = new KafkaProducer[String, String](props)


    /*
    val ss = SparkSession .builder()
      .appName("AuthCSVToKafkaJob")
      .master("local[*]")
      .getOrCreate()
    // How many number of authentication rows are there for the State = Karnataka
    // using accumulator
    // master
    val sc = ss.sparkContext
    // worker
    val textFileRDD = sc.textFile("hdfs://localhost:9000/testData/auth.csv")
    sc.stop()

     */

    /*
    val sparkConf = new SparkConf()
    sparkConf.setAppName("AuthCSVToKafkaJob");
    sparkConf.setMaster("spark://Umeshs-MacBook-Pro.local:7077")

    val sparkContext = new SparkContext(sparkConf)

    val textFileRDD = sparkContext.textFile("hdfs://localhost:9000/testData/auth.csv")
    */

    var i = 0

    /*
    textFileRDD.foreach(each =>{
      //var data = new ProducerRecord[String, String]("AUTH-TOPIC", "auth-csv-line-"+i, each.toString)
      producer.send(new ProducerRecord[String, String]("AUTH-TOPIC", "auth-csv-line-"+i, each.toString))
      println("pushing line "+i+"into kafka")
      //println(each)
      i=i+1
    })
    */

    val fileName = "/Users/umeshmoorthy/bigData/scala/testData/auth.csv"
    // Enter your Kafka input topic name
    val topicName = "AUTH-TOPIC"
    for (line <- Source.fromFile(fileName).getLines().drop(1)) { // Dropping the column names
      // Extract Key
      val key = line.split(","){0}
      // Prepare the record to send
      val record: ProducerRecord[String, String] = new ProducerRecord[String, String](topicName, key, line)
      // Send to topic
      producer.send(record)
    }

    producer.flush()
    producer.close()

  }

}
