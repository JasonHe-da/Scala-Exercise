package S_99_Scala


object P10 {
  def main(args: Array[String]): Unit = {
    // P10 (*) Run-length encoding of a list.
    val a = encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    println(a)
  }

  def encode[A]( list : List[A]) : List[(Int, A)] = {
    if (list.isEmpty) List()
    else {
      val (packed, next) = list span { _ == list.head }
      val tupled = (packed.length, packed.head)
      if (next == Nil) List(tupled)
      else tupled :: encode(next)
    }
  }


}
