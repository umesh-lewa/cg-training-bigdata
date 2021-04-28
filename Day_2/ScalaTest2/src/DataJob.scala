object DataJob {

  // Java - public static void main(Strings args)
  // One or more entry point
  // Entry point
  def main(args : Array[String]) = {
    computeData(10001, "HBase")
    println("Job Running")
  }

  // void - java
  // unit - scala
  def computeData(id : Int, dataName : String): Unit = {
    // complex computation
    println("ID is - " + id + " data is - " + dataName)
  }

}
