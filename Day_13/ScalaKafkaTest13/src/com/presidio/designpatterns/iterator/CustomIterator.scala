package com.presidio.designpatterns.iterator

trait CustomIterator[T] {
  def hasNext():Boolean;
  def next():T
}
