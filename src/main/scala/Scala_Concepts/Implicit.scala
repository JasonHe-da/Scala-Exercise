package Scala_Concepts

import scala.language.implicitConversions

object Implicit {
  def main(args: Array[String]): Unit = {
    val new12 = MyRichInt(12 )
    println(new12.myMax(15))

    // 1. implicit function
    //    implicit def convert(num:Int): MyRichInt = MyRichInt(num)

    //    println(12.myMax(15))


    println("---------------------------")

    // implicit class

    //    implicit case class MyRichInt2( self:Int) {
    //      def myMax2(n: Int): Int = if (n < self) self else n
    //      def myMin2(n: Int): Int = if (n < self) n else self
    //    }
    //
    //    println(12.myMax2(15))



    println("---------------------------")

    // implicit parameters

    implicit  val str: String = "alice"
    implicit  val num: Int = 18
    //    implicit  val str2: String = "alice"
    def sayHello(implicit name:String): Unit = {
      println("hello, " + name)
    }

    sayHello

    def hiAge: Unit = {
      println("hi, " + implicitly[Int])

    }
    hiAge
  }




}


case class MyRichInt( self:Int) {
  def myMax(n: Int): Int = if (n < self) self else n
  def myMin(n: Int): Int = if (n < self) n else self
}
