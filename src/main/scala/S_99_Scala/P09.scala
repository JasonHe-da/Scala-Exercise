package S_99_Scala

import scala.collection.mutable.ListBuffer

object P09 {


  def main(args: Array[String]): Unit = {
    //  P09 (**) Pack consecutive duplicates of list elements into sublists.
    //  If a list contains repeated elements they should be placed in separate sublists.
    val a = pack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    println(a)
  }

  //  def wrapper[A](ls: List[A]): List[List[A]] = {
  //    var cur: ListBuffer[List[A]] = ListBuffer()
  //    def compressFunctional(ls: List[A], curList: ListBuffer[List[A]]): List[A] =
  //      ls.foldLeft(List[A]()) { (r, h) =>
  //        if (r.isEmpty || r.head == h)  h :: r
  //        else {
  //          cur += r
  //          List[A](h)
  //        }
  //
  //      }.reverse
  //    compressFunctional(ls, cur)
  //    cur.toList
  //  }
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }
}
