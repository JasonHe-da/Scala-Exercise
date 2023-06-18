package S_99_Scala

object P15 {
  def main(args: Array[String]): Unit = {
    // P15 (**) Duplicate the elements of a list a given number of times.
    val a = duplicateN(3, List('a', 'b', 'c', 'c', 'd'))
    println(a)
  }

  def duplicateN[A]( time: Int, list: List[A]) : List[A] = {
    list.flatMap( x => List.fill(time)(x) )
  }


}
