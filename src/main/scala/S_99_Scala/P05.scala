package S_99_Scala

import scala.collection.mutable.ListBuffer


object P05 {
  // P05 (*) Reverse a list.
  def main(args: Array[String]): Unit = {
    println(reverse(List(1, 1, 2, 3, 5, 8)))
  }

//  def reverse(list: List[Int]) : List[Int] = list match{
//    case Nil => Nil
//    case head::tail => reverse(tail)
//
//  }

  def reverse(list: List[Int]) : List[Int] = list.foldLeft(List[Int]()){ (r, h) => {
    println(h)
    println(r)
    println("----------")
    h :: r
  } }
}
