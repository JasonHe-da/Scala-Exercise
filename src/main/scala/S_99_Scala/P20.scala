package S_99_Scala

object P20 {
  def main(args: Array[String]): Unit = {
    // P20 (*) Remove the Kth element from a list.
    val a = removeAt(3, List('a', 'b', 'c', 'd'))
    println(a)
  }

  def removeAt[A](place: Int, list: List[A]) : (List[A], A) = {
    def removeAtInner(place:Int, list:List[A], accum : List[A]): (List[A], A) = (place, list) match {
      case (0, head::tail) => (accum.reverse:::tail, head)
      case (_, head::tail) => removeAtInner(place - 1, tail, head::accum)
    }
    removeAtInner(place, list, List())
  }



}
