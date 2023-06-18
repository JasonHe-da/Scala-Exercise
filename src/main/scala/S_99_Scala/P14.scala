package S_99_Scala

object P14 {
  //  P14 (*) Duplicate the elements of a list.

  def main(args: Array[String]): Unit = {
    val a = duplicate(List('a', 'b', 'c', 'c', 'd'))
    println(a)
  }


  def duplicate[A](list : List[A]): List[A] = {
    list.flatMap( x => List(x,x))
  }
}
