package com.presidio.designpatterns.mediator

trait IAlertMediator {
  def addSubscriberToDynamicAlert(alertobserver:AlertObserver)
  def addSubscriberToThresholdAlert(alertobserver:AlertObserver)
  def publishAlert(alert:Alert)
}
