object DataJob2 {

  // Type Inferences : Scala is a type inferenced
  def main(args : Array[String]) = {
    //val noSQL = 40005d
    //val noSQL = 40005f
    val noSQL = "Cassandra"
    val outputData = computeData(10001, "HBase")
    println(outputData)
    println("Job Running")
  }
  // void - java
  // unit - scala
  def computeData(id : Int, dataName : String): String = {
    val noSQL = "Cassandra"
    println("ID is - " + id + " data is - " + dataName)
    val concomitate = noSQL + "_" + dataName
    return concomitate
  }

  def trySomething(a : String,b : String): Unit ={

  }
}
