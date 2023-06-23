package S_99_Scala

import scala.collection.mutable.ListBuffer

object P26 {
  def main(args: Array[String]): Unit = {
    // P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
    val b = List('a', 'b', 'c', 'd')
    println(b.zipWithIndex)
    val a = combinations(3, List('a', 'b', 'c','d'))
    println(a)
  }

  //  def combinationsOwn(num:Int , list:List[Char]): ListBuffer[ListBuffer[Char]] = {
  //    val res: ListBuffer[ListBuffer[Char]] = ListBuffer()
  //    def combinationInner(num:Int, list:List[Char], cur: ListBuffer[Char]): Unit = {
  //      if (num == 0){
  //        res += cur.clone()
  //      }else{
  //        for( x <- list.indices) {
  //          cur += list(x)
  //          combinationInner(num - 1, list.tail, cur)
  //          cur -= list(x)
  //        }
  //      }
  //    }
  //    combinationInner(num, list, ListBuffer())
  //    res
  //  }


  // fprintln(ls)latMapSublists is like list.flatMap, but instead of passing each element
  // to the function, it passes successive sublists of L.
  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => {
        val a = f(sublist)
        val b = flatMapSublists(tail)(f)
        println("sublist :" + sublist)
        println( "a :" + a )
        println( "b :" + b )
        println( "a ::: b " + (a ::: b))
        a ::: b
      }
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] = {


    if (n == 0) {

      List(Nil)
    }
    else {
    flatMapSublists(ls) { sl =>
        combinations(n - 1, sl.tail) map { a => sl.head :: a }
      }
    }
  }


  def combinationsFor[T]( k: Int, elements: List[T]): List[List[T]] = {
    if (k == 0) {
      List(Nil) // Base case: Empty combination
    } else if (k > elements.length) {
      Nil // Base case: Empty list
    } else if (elements.length == k) {
      List(elements) // Base case: Single combination with all elements
    } else {
      for {
        (head, i) <- elements.zipWithIndex
        tail = elements.drop(i + 1)
        subCombination <- combinationsFor( k - 1, tail)
      } yield head :: subCombination
    }
  }

}
