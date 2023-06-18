package S_99_Scala

object P13 {
  def main(args: Array[String]): Unit = {
    // P13 (**) Run-length encoding of a list (direct solution).
    val a = encodeDirect(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    println(a)
  }


  def encodeDirect(value: List[Char]): List[(Int, Char)] = {
    if (value == Nil) Nil
    else {
      val (pack, next) = value.span(_ == value.head)
      val b = (pack.length, pack.head)
      if (next == Nil) List(b)
      else List(b) ::: encodeDirect(next)
    }

  }


}
