package S_99_Scala


object P11 {
  def main(args: Array[String]): Unit = {
    val a = encodeModified(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    println(a)
  }

  def encodeModified(value: List[Char]): List[Any] = {
    P10.encode(value).map(
      x =>
        if (x._1 == 1) x._2
        else x
    )

  }
  // typesafe with Either
  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    P10.encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }

//  // rewrite above with disjunction
//  def encodeModified3[A](ls: List[A]): List[A] \/ List[(Int, A)] =
//    P10.encode(ls) map { t => if (t._1 == 1) -\/(t._2) else \/-(t) }
}
