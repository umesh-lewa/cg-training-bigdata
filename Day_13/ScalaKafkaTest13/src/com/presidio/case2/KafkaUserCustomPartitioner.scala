package com.presidio.case2

import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.utils.Utils
import org.apache.kafka.common.{Cluster, InvalidRecordException}

import java.util

class KafkaUserCustomPartitioner extends Partitioner {

  override def close(): Unit = {}

  override def configure(map: util.Map[String, _]): Unit = {}

  override def partition(topic: String,
                         key: scala.Any,
                         keybytes: Array[Byte],
                         value: scala.Any,
                         valuebytes: Array[Byte],
                         cluster: Cluster): Int = {

    if ((keybytes == null) || (!key.isInstanceOf[String]))
      throw new InvalidRecordException("All messages must have a key")

    val key_ = key.asInstanceOf[String]
    if (key_.startsWith("QURE")) {
      val p = Utils.toPositive(98);
      p
    } else {
      val p = Utils.toPositive(19);
      p
    }

  }

}
