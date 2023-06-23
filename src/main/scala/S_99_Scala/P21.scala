package S_99_Scala

object P21 {
  def main(args: Array[String]): Unit = {
   // P21 (*) Insert an element at a given position into a list.
      val a = insertAtTail("new", 1, List('a', 'b', 'c', 'd'))
    println(a)
  }

  def insertAt[A](word: A, index: Int, list: List[A]): List[A] = (index, list) match {
    case (0, list) => word::list
    case (p, head::tail) => head :: insertAt(word, p-1, tail)
  }


  def insertAtTail[A](word: A, index: Int, list: List[A]): List[Any] = {
    def insertAtTailInner[A](index:Int, list:List[A], accumulator:List[A]) : List[Any] = (index, list) match {
      case (0, list) => accumulator.reverse ::: word :: list
      case (p, head::tail) => insertAtTailInner( p-1, tail, head::accumulator)
    }
    insertAtTailInner(index, list, List())
  }


  def insertAtSplit[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
}
