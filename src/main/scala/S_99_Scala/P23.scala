package S_99_Scala
import scala.util.Random
object P23 {
  def main(args: Array[String]): Unit = {
    //    P23 (**) Extract a given number of randomly selected elements from a list.
    val a = randomSelectOwn(3, List('a', 'b', 'c', 'd', 'f', 'g', 'h'))
    println(a)
  }

  def randomSelectOwn[A](num: Int, list:List[A]) : List[A] = {
    val rand = new scala.util.Random
    def randomSelectInner[A](num : Int, list : List[A], result: List[A]): List[A] = num match {
      case 0 => result.reverse
      case p => {
        val a = P20.removeAt(rand.nextInt(list.length), list)
        randomSelectInner(p-1, a._1, a._2::result)
      }
    }
    randomSelectInner(num, list, List())
  }



  import P20.removeAt

  //  def randomSelect1[A](n: Int, ls: List[A]): List[A] =
  //    if (n <= 0) Nil
  //    else {
  //      val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
  //      e :: randomSelect1(n - 1, rest)
  //    }

  // It can be expensive to create a new Random instance every time, so let's
  // only do it once.
  def randomSelect1[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = removeAt(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new util.Random)
  }
}
