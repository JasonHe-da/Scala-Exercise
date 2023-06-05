package PatternMatching

object MatchTuple {


  def main(args: Array[String]): Unit = {
    val (x,y) = (10, "hello")
    val List(first, second, _*) = List(1,2,3,4,5,6,7)
    val a :: b :: c = List(1, 2, 3, 4, 5, 6, 7)


    // in for loop using pattern matching
    val list: List[(String, Int)] = List(("a",1),("b",2),("c",3))

    // original loop
    for (elem <- list){
      println(elem._1 + " " + elem._2)
    }

//    val list2: List[(String, Int] = List(("a",1),("b",2),("c",3))

    // pattern matching style
    for((x,y) <- list) {
      println(x + " " + y)
    }


  }

}
