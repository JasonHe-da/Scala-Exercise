package S_99_Scala

object P16 {
  def main(args: Array[String]): Unit = {
    // P16 (**) Drop every Nth element from a list.
    val a = drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'), 3)
    // List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    println(a)
  }

  def drop[A](n: Int, list: List[A], a: Int): List[A] = (n, list, a) match {
    case (_, Nil, a) => list
    case (1, _::tail, a) => drop(a, tail, a)
    case (n, list , a) => list.head :: drop( n-1, list.tail, a)
  }


  def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => result.reverse
      case (1, _ :: tail) => dropR(n, tail, result)
      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
    }
    dropR(n, ls, Nil)
  }
}
