package S_99_Scala

object P07 {
  //  P07 (**) Flatten a nested list structure.
  //  Example:
  //
  //    scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  def main(args: Array[String]): Unit = {
    val a = List(List(1, 1), 2, List(3, List(5, 8)))
    println(flatten(a))
  }

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }
}
