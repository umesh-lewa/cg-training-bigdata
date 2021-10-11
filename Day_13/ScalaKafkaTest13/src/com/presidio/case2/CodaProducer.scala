package com.presidio.case2

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

import java.util.Properties

object CodaProducer {

  def main(args:Array[String]): Unit ={

    /*
    Wells fargo as a bank has multiple systems for finance, risk and liquidity managements. These systems consume accounting and management contract data from different business lines. These data set needs
    to be transformed into different financial instruments as per usage and then need to report as balance sheets to banking driving management and also to european union. QURE is a system in wells-fargo which does the above processing of contract data.
    Wells fargo has a system QURE. QURE has only two end-points. One is Kafka end-point and the other is Rest endpoint. Write a producer to feed inside QURE-DATA-LINEAGE topic.
    Participants will be able to achieve the following when they do this case-study:
    1. Start the zookeeper
    2. Start the kafka-broker
    3. Create the topic (QURE-DATA-LINEAGE) using command line provided by kafka.
    4. Write the scala producer in-order to pass data to the topic QURE-DATA-LINEAGE.
    5. Write also a call-back for the producer if the data has correctly been written to kafka.
    6. Write the scala-producer with having 100 partitions.
    7. Code in the scala-producer to put in the data in the 98 partition (specific partition).
    8. Also code in the producer to send the data in bulk using flush and close the producer.
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
    props.put("partitioner.class", "com.presidio.case2.KafkaUserCustomPartitioner")

    val callback = new Callback {
      override def onCompletion(recordMetadata: RecordMetadata, e: Exception) = {
        if(e==null){
          println("producer record added to topic successfully....!!!")
        }else{
          println("producer record not added to topic....!!!")
          println(e.printStackTrace())
        }
        println("LEO - " + recordMetadata.offset())
        println(recordMetadata.topic())
        println(recordMetadata.partition())
      }
    }

    val producer = new KafkaProducer[String, String](props)

    val data = new ProducerRecord[String, String]("QURE-DATA-LINEAGE", "QURE-coda-cold", "coda-hot")

    producer.send(data, callback)

    producer.flush()

  }

}
