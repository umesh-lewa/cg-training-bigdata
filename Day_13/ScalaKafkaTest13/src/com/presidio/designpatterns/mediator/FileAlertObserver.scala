package com.presidio.designpatterns.mediator

class FileAlertSubscriber() extends AlertObserver {
  def publish(alert: Alert): Unit= {
    println("FileAlertSubscriber called")
    // logges the breach into a file for further analysys
  }
}
