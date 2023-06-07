package Scala_Concepts

object Nil_None_Null_Nothing {
  // 1 - the null reference
  // null pointer exception

  val anAbsentString: String = null


  // 2 - Null - the type of the null reference
  // Null type
  val theNullReference: Null = null
  val noString: String = theNullReference
  //  val noInt : Int = theNullReference
  // subtype of all reference types

  // 3 - Nil = empty list
  val anEmptyList : List[Int] = Nil
  println(Nil.length)

  // 4 - None is a subtype of Options
  // None is a regular value Meaning that it has fields and methods

  val anAbsentInt : Option[Int] = None
  val aPresentInt : Option[Int] = Some(42)
  println(anAbsentInt.isEmpty) // this won't throw error

  // 5 - Unit
  // void in Java
  // value : ()
  // regular value

  // 6 - Nothing = no value at all
  // throwing exception
  val nothingInt:Int = throw new RuntimeException("No int") // return Nothing



  def main(args: Array[String]): Unit = {
    println(theNullReference.getClass)
  }
}
