package S_99_Scala

object P01_Scala {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 1, 2, 3, 5, 8)

    def Find_the_last_element_of_a_list(l: List[Int]): Int = {
      l.last
    }

    println(Find_the_last_element_of_a_list(list1))
  }
}
