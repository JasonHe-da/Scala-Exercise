package Scala_Concepts

import scala.language.postfixOps

object ForComprehension {
  def main(args: Array[String]): Unit = {
    // Java For Syntax for(int i = 0; i < 10; i++){}

    for (i <- 0 to 9) {}
    for (i <- 0 until 9) {}
    for (i <- 0 until 9 if i != 2) {}
    for (i <- 0 to 9 by 2) {}
    for (i <- 9 to 0 by -2) {}
    for (i <- 1 to 10 reverse) {}
    val a = for (i<- 1 to 10) {
      i
    }

    val b = for (i<- 1 to 10) yield i
  }
}
