package com.presidio.case2

import org.apache.kafka.clients.producer.Partitioner

class KafkaUserCustomPartitioner extends Partitioner {

  override def close(): Unit = {}

  override def configure(map: util.Map[String, _]): Unit = {}

  override def partition(topic: String, key: scala.Any, keybytes: Array[Byte],
                         value: scala.Any, valuebytes: Array[Byte], cluster: Cluster): Int = {
    val key_ = key.asInstanceOf[String]
    if (key_.startsWith("M"))
      10
    else if (key_.startsWith("C"))
      16
    else
      19
  }

}
