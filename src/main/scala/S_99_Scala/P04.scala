package S_99_Scala

import scala.annotation.tailrec

object P04 {
  def main(args: Array[String]): Unit = {
    // P04 (*) Find the number of elements of a list.
    println(lengthPatternMatching(List()))

  }

  // easiest way by calling List method
  def length(list: List[Int]) : Int = list.length

  @tailrec
  def lengthPatternMatching(list: List[Int], a:Int = 0) : Int = (list, a) match {
    case (Nil, a) => a
    case ( _:: tail, a) => lengthPatternMatching(tail, a + 1)
  }


}
