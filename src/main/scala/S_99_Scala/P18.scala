package S_99_Scala

object P18 {
  def main(args: Array[String]): Unit = {
    //    P18 (**) Extract a slice from a list.
    //    val a =  sliceBuildIn(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val a =  slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    println(a)
  }


  def sliceBuildIn[A](start: Int, end: Int, list: List[A]) = {
    list.slice(start, end)
  }

  def sliceMyOwn[A](start: Int, end: Int, list: List[A]) = {
    val EndList = list.take(end)
    val finalList = EndList.drop(start)
    finalList
  }

  def slice[A](start: Int, end: Int, list: List[A]) = {

    def sliceInner[A]( list: List[A], index: Int, curList: List[A]): List[A] = (index, list) match{
      case (index, list) if index >= end => curList.reverse
      case (index, head::tail) if index < start => sliceInner( tail, index + 1, curList)
      case (index, head::tail) => sliceInner(tail, index + 1, head:: curList )
    }
    sliceInner( list, 0, List())
  }
}
