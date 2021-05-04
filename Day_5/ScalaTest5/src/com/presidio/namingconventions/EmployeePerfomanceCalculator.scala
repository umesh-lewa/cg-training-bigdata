package com.presidio.namingconventions

class EmployeePerfomanceCalculator {

  def main(args: Array[String]): Unit ={

    val emp = new Employee()

    if(emp.doWork().equals("Good")){
      emp.empPerf = "Good"
    }

  }

}
