package PatternMatching

object MatchCaseClass {
  def main(args: Array[String]): Unit = {
    val student = Student1("Jason", 18)

    // object content value pattern matching
    val result =student match {
      case Student1("Jason", 18) => "Jason, 18"
      case _ => "whatever"
    }
    println(result)
  }

}

case class Student1(name:String, age:Int)
