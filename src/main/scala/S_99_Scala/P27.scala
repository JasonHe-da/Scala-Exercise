package S_99_Scala
import P26.combinations


object P27 {
  def main(args: Array[String]): Unit = {
    // P27 (**) Group the elements of a set into disjoint subsets.
    val a = group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
    val b = group3D(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
    println(a)
    println(b)
    println(a == b)
  }

  // my solution
  def group3[A](list: List[A]) : List[List[Any]] = {
    for {
      x <- P26.combinationsFor(2, list)
      y <- P26.combinationsFor(3, list.filter(d => !x.contains(d)))
    } yield x :: y :: List(list.filter(d => !x.contains(d) && !y.contains(d)))

  }

  // official solution
  def group3D[A](ls: List[A]): List[List[List[A]]] =
    for {
      a <- combinations(2, ls)
      noA = ls diff a
      b <- combinations(3, noA)
    } yield List(a, b, noA diff b)


  def group3General[A](par: List[Int] , ls: List[A]): List[List[List[A]]] = {
    val one = par.head
    val two = par(1)
    for {
      a <- combinations(one,  ls)
      noA = ls diff a
      b <- combinations(two, noA)
    } yield List(a, b, noA diff b)
  }
}
