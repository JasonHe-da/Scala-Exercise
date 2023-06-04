object extendedExercise {
  def main(args: Array[String]): Unit = {
    val fun = (a:Int, b:String, c:Char) => a == 0 && b == "" && c == '0'

    def func(a:Int):String => Char => Boolean = {
      def f1(b:String) :Char => Boolean = {
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

}
