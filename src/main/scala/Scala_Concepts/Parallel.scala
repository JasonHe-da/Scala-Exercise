package Scala_Concepts

object Parallel {
  def main(args: Array[String]): Unit = {
    val Strings = (1 to 100).map(
      x => Thread.currentThread().getName
    )
  }
}
