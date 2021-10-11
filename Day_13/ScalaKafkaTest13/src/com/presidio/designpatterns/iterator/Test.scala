package com.presidio.designpatterns.iterator

object Test {

  def main(args:Array[String]): Unit ={

    var list=scala.collection.mutable.ListBuffer[Alert]();
    var alert1=new Alert(1,2,3,"PW",4);
    var alert2=new Alert(2,2,3,"PW",4);
    var alert3=new Alert(3,2,3,"PW",4);
    var alert4=new Alert(4,2,3,"PW",4);
    list +=alert1
    list +=alert2
    list +=alert3
    list +=alert4
    var agg=new AlertAggregator(list)
    var iterator=agg.iterator()
    while(iterator.hasNext()) {
      println(iterator.next().elementId)
    }

  }

}
