package PatternMatching

object MatchObject {
  def main(args: Array[String]): Unit = {
    val student = new Student("Jason", 18)

    // object content value pattern matching
    val result =student match {
      case Student("Jason", 18) => "Jason, 18"
      case _ => "whatever"
    }
    println(result)
  }
}


class Student(val name:String, val age: Int)

object Student{
  def apply(name:String, age:Int):Student = new Student(name, age)
  def unapply(student: Student): Option[(String, Int)] = {
    if (student == null) None else Some((student.name, student.age))
  }

}