package com.presidio.designpatterns.mediator

class ThresholdAlert(var elementId:Int,var metricMetadataId:Int,var metricMetadataHourlyId:Int,var durationType:String,var durationInterval:Int,var alertType:String) extends Alert {
}
