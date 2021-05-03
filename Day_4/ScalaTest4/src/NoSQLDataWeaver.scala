import com.presidio.functions.{DefaultFunction, EmptyFunction, NamedFunction, ProcedureFunction, SymbolFucntion, VarriableArgumentsFunction}

object NoSQLDataWeaver {

  def main(args: Array[String]): Unit ={

    //def proc(procMsg : String) = println(s"Procedure message : $procMsg")
    //proc("Something")

    val proc = new ProcedureFunction()
    proc.proc("Proc message")

    //def getConstantVal():String = {
    //  return "Some Constant"
    //}
    //val c = getConstantVal();

    val empty = new EmptyFunction()
    val c = empty.getConstantVal()
    println(c)

    /*
    def namedFunc(val1:String,val2:String,val3:String): Unit ={
      println(val1)
      println(val2)
      println(val3)
    }
    namedFunc(val3="val3",val2="val2",val1="val1")
    */

    val named = new NamedFunction()
    named.namedFunc(val3="val3",val2="val2",val1="val1")

    /*
    def defaultFunc(val1:String="default val1"): Unit ={
      println(val1)
    }
    defaultFunc()
    */

    val default = new DefaultFunction()
    default.defaultFunc()

    /*
      def varArgFunc(args : String*) : Unit = {
        for (i <- args)
          println(i)
      }
    */

    val symbol = new SymbolFucntion()
    val v = symbol.++("Something")
    println(v)

    val vArgFunction = new VarriableArgumentsFunction()
    vArgFunction.varArgFunc("1","2","3")

  }

}
