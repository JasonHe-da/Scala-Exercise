package S_99_Scala

object P24 {
  def main(args: Array[String]): Unit = {
    //    P24 (*) Lotto: Draw N different random numbers from the set 1..M
    val a = lotto(6, 49)
    print(a)
  }

  def lotto(s:Int, e:Int): List[Int] = {
    P23.randomSelectOwn(s, List.range(1, e + 1))

  }
}
