package S_99_Scala

import scala.annotation.tailrec

object P06 {
  //  P06 (*) Find out whether a list is a palindrome.
  def main(args: Array[String]): Unit = {
    println(isPalindrome(List(1, 3, 3, 2, 1)))
  }

  @tailrec
  def isPalindrome[A](list : List[A]) : Boolean = list match {
    case Nil => true
    case list if list.length == 1 => true
    case head +: b :+ tail if head == tail => isPalindrome(b)
    case _ => false
  }
}
