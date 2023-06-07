package Scala_Concepts

import scala.collection.mutable

object Queue {
  def main(args: Array[String]): Unit = {
    val queue = new mutable.Queue[String]()
    queue.enqueue("a", "b", "c")
    println(queue)
    println(queue.dequeue())
  }

}
