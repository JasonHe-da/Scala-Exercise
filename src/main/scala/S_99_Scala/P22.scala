package S_99_Scala

object P22 {
  def main(args: Array[String]): Unit = {
    //    P22 (*) Create a list containing all integers within a given range.
    val a = range(4, 9)
    println(a)
  }


  def range(value: Int, value1:Int): List[Int] = {
    (value to value1).toList
  }

  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None         => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }
  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }
}
