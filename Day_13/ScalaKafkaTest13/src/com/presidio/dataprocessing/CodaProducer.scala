package com.presidio.dataprocessing

import java.util.Properties
import java.util
import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.Cluster
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object CodaProducer {

  def main(args : Array[String]) = {

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
    val data = new ProducerRecord[String, String]("MONGODB-TOPIC", "test-partition-key", "test-partition-value")
    producer.send(data)
    producer.flush()

  }

}
