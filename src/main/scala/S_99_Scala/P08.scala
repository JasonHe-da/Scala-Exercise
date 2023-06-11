package S_99_Scala

object P08 {
  def main(args: Array[String]): Unit = {
    //  P08 (**) Eliminate consecutive duplicates of list elements.
    //  If a list contains repeated elements they should be replaced with a single copy of the element.  The order of the elements should not be changed.

    val a = compressFunctional(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    println(a)

  }

  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }

  def compress(a: List[Char]): List[Char] = a match {
    case first::second::tail => {
      if (first == second)
        compress(first::tail)
      else
        first::compress(second::tail)
    }
    case first :: second => {
      if (first == second)
        List(first)
      else
        first :: second
    }
    case b => b
    case _ => List()


  }


  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }.reverse
}
