package com.presidio.designpatterns.iterator

import scala.collection.mutable.ListBuffer

class AlertIterator(alertAgg: AlertAggregator) extends CustomIterator[Alert] {
  var list: ListBuffer[Alert] = alertAgg.list
  var position: Int = 0;
  def hasNext(): Boolean =
  {
    if (position >= list.size) {
      return false;
    } else {
      return true;
    }
  }
  def next(): Alert=
  {
    val alert=list(position)
    position+=1
    alert
  }
}
