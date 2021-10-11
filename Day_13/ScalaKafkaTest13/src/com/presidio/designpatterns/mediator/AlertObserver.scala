package com.presidio.designpatterns.mediator

trait AlertObserver {
  def publish(alert: Alert): Unit;
}
