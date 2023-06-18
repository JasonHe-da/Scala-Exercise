package S_99_Scala

object P17 {
  //  P17 (*) Split a list into two parts.
  def main(args: Array[String]): Unit = {
    val a = split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    println(a)
  }

  def split[A](place: Int, list : List[A]) : (List[A], List[A]) = {
    def splitInner[A](firstList:List[A], secondList:List[A], place: Int) : (List[A], List[A]) = (place, secondList) match {
      case (0, secondList) => (firstList, secondList)
      case (p, head::tail) if p > 0 => splitInner(head :: firstList, tail, p - 1)
      case (p, head::tail) if p < 0 => (firstList, secondList)
    }
    splitInner(List(), list, place)
  }
}
