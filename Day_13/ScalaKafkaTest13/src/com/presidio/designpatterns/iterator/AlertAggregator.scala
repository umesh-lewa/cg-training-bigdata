package com.presidio.designpatterns.iterator

import scala.collection.mutable.ListBuffer

class AlertAggregator(val list:ListBuffer[Alert]) {
  def iterator():AlertIterator= {
    new AlertIterator(this)
  }
}