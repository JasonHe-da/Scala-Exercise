package S_99_Scala

object P19 {
  def main(args: Array[String]): Unit = {
    // P19 (**) Rotate a list N places to the left.
    val a = rotate(-2, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    println(a)
  }

  def rotate[A](num:Int, list: List[A]) : List[A] = {
    def rotateInner[A](numInner: Int, listInner:List[A], accumulator: List[A]) : List[A] = (numInner, listInner) match {
      case (0, listInner) =>  listInner ::: accumulator.reverse
      case (p, head:: tail) => rotateInner(p-1, tail, head::accumulator)

    }
    if (num < 0){
      rotateInner(list.length - (num*(-1)), list, List())

    }else{
      rotateInner(num, list, List())

    }
  }


}
