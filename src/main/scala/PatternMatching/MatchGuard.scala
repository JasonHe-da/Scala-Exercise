package PatternMatching

object MatchGuard {
  def main(args: Array[String]): Unit = {
    println(describeType(List(23,12,12)))
  }

  // match guard
  def abs(num:Int):Int = {
    num match {
      case i if i >= 0 => i
      case i if i < 0 => -i
    }
  }

  // match value
  def describeConst(x:Any) :String = x match {
    case 1 => "num one"
    case "hello" => "String hello"
    case true => "boolean true"
    case '+' => "char"
    case _ => "whatever"
  }

  // match type
  def describeType(x:Any):String = x match{
    case i : Int => "Int " + i
    case i : String => "String" + i
    case i : List[String] => "List " + i
    case i : Array[Int] => "Array[Int]" + i.mkString("_")
    case _ => "whatever"

  }

}
