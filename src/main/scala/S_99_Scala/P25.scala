package S_99_Scala

object P25 {
  def main(args: Array[String]): Unit = {
    // P25 (*) Generate a random permutation of the elements of a list.

    val a = randomPermute(List('a', 'b', 'c', 'd', 'e', 'f'))
    println(a)
    val b = randomPermute(List('a'))
    println(b)
  }

  def randomPermute[A](list:List[A]):List[A] = {
    P23.randomSelectOwn(list.length, list)

  }
}
