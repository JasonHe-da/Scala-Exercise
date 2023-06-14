package Scala_Concepts

object HighOrderFunction {
  def main(args: Array[String]): Unit = {
    val g = nTimes((x)=> x + 1, 2)
    println(g(2))

    val fun = (a: Int, b: String, c: Char) => a == 0 && b == "" && c == '0'

    def func(a: Int): String => Char => Boolean = {
      def f1(b: String): Char => Boolean = {
        def f2(c: Char): Boolean = {
          a == 0 && b == "" && c == '0'
        }

        f2
      }

      f1
    }


    println(fun(0, "", '0'))
    println(fun(1, "", 'd'))
    println(fun(0, "c", '0'))
    println(fun(0, "", '0'))
    println("========================")
    println(func(0)("")('0'))
    println(func(1)("")('0'))
    println(func(0)("c")('0'))
    println(func(0)("")('d'))
  }

  def nTimes(f:Int => Int, n:Int): Int => Int =
    if ( n <= 0) (x:Int) => x
    else (x :Int) => nTimes(f, n-1)(f(x))

}
