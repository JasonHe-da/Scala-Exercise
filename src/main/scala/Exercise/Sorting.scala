package Exercise

import scala.annotation.tailrec

object Sorting {

  def sortList(list: List[Int]):List[Int] = {
    // insertion sort
    def insert(num:Int, sortedList:List[Int]) : List[Int] = {
      if (sortedList.isEmpty || num <= sortedList.head) num :: sortedList
      else sortedList.head :: insert(num, sortedList.tail)
    }

    // base case
    if (list.isEmpty || list.tail.isEmpty) list
    else insert(list.head, sortList(list.tail))

  }

  // Tail Rec
  def sortListBetter(list: List[Int]):List[Int] = {
    @tailrec
    def insertTailrec(num:Int, sortedList:List[Int], accumulator: List[Int]) : List[Int] = {
      if (sortedList.isEmpty || num <= sortedList.head) accumulator.reverse ++ (num :: sortedList)
      else insertTailrec(num, sortedList.tail, sortedList.head :: accumulator)
    }

    @tailrec
    def sortTailrec(list: List[Int], accumulator: List[Int]): List[Int] = {
      if (list.isEmpty) accumulator
      else sortTailrec(list.tail, insertTailrec(list.head, accumulator, Nil))
    }

    sortTailrec(list, Nil)
  }

  def main(args: Array[String]): Unit = {
    val test: List[Int] = List(1,23,123,451,241,243,41,23,43,254,135,34,523,5235)
    println(sortListBetter(test))

  }


}
