package com.presidio.designpatterns.mediator

class OracleAlertSubscriber() extends AlertObserver {
  def publish(alert: Alert): Unit=
  {
    // insert alert into oracle for further analyses
    println("OracleAlertSubscriber called")
  }
}
