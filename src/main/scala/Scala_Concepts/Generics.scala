package Scala_Concepts

object Generics {
  def main(args: Array[String]): Unit = {
    // 1. +T -T
    val child: Parent = new Child
    val childList: MyList[Parent] = new MyList[Child]


    // 2. upperbound and lowerbound
    val child2: Child = new Child
    def test[ A <: Child] (a: A) = {
      println(a.getClass.getName)
    }
    test[SubChild](new SubChild)

  }
}

class Parent

class Child extends Parent

class SubChild extends Child

class MyList[+A]
