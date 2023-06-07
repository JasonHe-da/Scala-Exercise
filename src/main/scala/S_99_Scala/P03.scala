package S_99_Scala

import scala.annotation.tailrec

object P03 {
  //  P03 (*) Find the Kth element of a list.
  //  By convention, the first element in the list is element 0.
  def main(args: Array[String]): Unit = {
    println(nth(5, List(1, 1, 2, 3, 5, 8)))
    println(nthRecursive(2)(List(1, 1, 2, 3, 5, 8)))
  }

  // my first try
  def nth(n:Int,list: List[Int]) : Int = {
    n match {
      case i if i >= list.length => -1
      case i if i < list.length => list(i)
    }
  }


  // answer
  @tailrec
  def nthRecursive[A](n: Int)(ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1)(tail)
    case (_, Nil      ) => throw new NoSuchElementException
  }
}
