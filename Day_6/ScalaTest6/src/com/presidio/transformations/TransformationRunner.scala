package com.presidio.transformations

import scala.collection.mutable.ListBuffer
import scala.io.Source

object TransformationRunner {

  def main(args:Array[String]): Unit ={

    /*
    val bufferedSource = Source.fromFile("/Users/umeshmoorthy/scala/testData/auth.csv")

    for (line <- bufferedSource.getLines()) {
      val cols = line.split(",").map(_.trim)
      println(cols(0))
    }

    bufferedSource.close
    */

    /*
    case class AuthBean(val authCode:String,val auaCode:String)

    var list = new ListBuffer[AuthBean]
    val csvFile = io.Source.fromFile("/Users/umeshmoorthy/scala/testData/auth.csv");

    for(line <- csvFile.getLines()){

      val lines = line.split(",")

      val ab = AuthBean(lines(0),lines(2))

      list+= ab
    }

    val authBeanList = list.toList
    authBeanList.foreach(each => println(each.auaCode))
    */
  }

}
