package com.presidio.fileio

import scala.io.Source

object FileRunner {

  def main(args: Array[String]) = {

    val file = Source.fromFile("/Users/umeshmoorthy/scala/testData/auth.csv")
    val lines = file.getLines()

    // by lines
    for (eachLine <- lines) {
      println(eachLine)
    }

    // by lines and columns
    for (eachLine <- lines) {
      val columns = eachLine.split(",")
      println(columns(3) + " ---- " + columns(5))
    }

  }

}
