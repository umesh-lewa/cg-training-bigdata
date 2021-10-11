package com.presidio.designpatterns.mediator

class AlertMediator extends IAlertMediator {

  val thresoldAlertToObserver: scala.collection.mutable.Map[String, scala.collection.mutable.ListBuffer[AlertObserver]] = scala.collection.mutable.Map[String, scala.collection.mutable.ListBuffer[AlertObserver]]()
  val dynamicAlertToObserver: scala.collection.mutable.Map[String, scala.collection.mutable.ListBuffer[AlertObserver]] = scala.collection.mutable.Map[String, scala.collection.mutable.ListBuffer[AlertObserver]]()

  def addSubscriberToDynamicAlert(alertobserver: AlertObserver) = {

    var list: Option[scala.collection.mutable.ListBuffer[AlertObserver]] = dynamicAlertToObserver.get("dynamic")

    if (list == None) {
      list = Some(scala.collection.mutable.ListBuffer[AlertObserver]())
      dynamicAlertToObserver.put("dynamic", list.getOrElse(null))
    }

    list.getOrElse(null) += alertobserver

  }

  def addSubscriberToThresholdAlert(alertobserver: AlertObserver) = {

    var list: Option[scala.collection.mutable.ListBuffer[AlertObserver]] = thresoldAlertToObserver.get("threshold")

    if (list == None) {
      list = Some(scala.collection.mutable.ListBuffer[AlertObserver]())
      thresoldAlertToObserver.put("threshold", list.getOrElse(null))
    }

    list.getOrElse(null) += alertobserver

  }

  def publishAlert(alert: Alert) = {

    if (alert.alertType == "dynamic") {
      for ((k, v) <- dynamicAlertToObserver) {
        v.foreach {
          e => e.publish(alert);
        }
      }
    } else if (alert.alertType == "threshold") {
      for ((k, v) <- thresoldAlertToObserver) {
        v.foreach {
          e => e.publish(alert);
        }
      }
    }

  }

}
