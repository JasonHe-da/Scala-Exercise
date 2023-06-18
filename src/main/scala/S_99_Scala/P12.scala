package S_99_Scala

object P12 {
  def main(args: Array[String]): Unit = {
    // P12 (**) Decode a run-length encoded list.
    val a = decode(List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e')))
    print(a)
  }

  def decode(value: List[(Int, Char)]): List[Char] = value match {
    case Nil => List()
    case head :: rest => List.fill(head._1)(head._2) ::: decode(rest)
  }
}
