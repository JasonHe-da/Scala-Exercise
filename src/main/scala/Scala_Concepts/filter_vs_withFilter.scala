package Scala_Concepts

import java.util.concurrent.atomic.AtomicInteger
import scala.collection.WithFilter

object filter_vs_withFilter {
  implicit val counter: AtomicInteger = new AtomicInteger(0)
//  implicit val counter: AtomicInteger = new AtomicInteger(0)
  def main(args: Array[String]): Unit = {


    val desiredProgrammers: List[Programmer] = programmers
      .filter(isMidOrSenior)
      .filter(knowsMoreThan1Language)


    // verify level Programmer(Kelly,Mid,List(JavaScript))
    //verify level Programmer(John,Senior,List(Java, Scala, Kotlin))
    //verify level Programmer(Dave,Junior,List(C, C++))
    //verify number of known languages Programmer(Kelly,Mid,List(JavaScript))
    //verify number of known languages Programmer(John,Senior,List(Java, Scala, Kotlin))
    //get name Programmer(John,Senior,List(Java, Scala, Kotlin))



  }
  val programmers: List[Programmer] = List(
    Programmer(name = "Kelly",
      level = Level.Mid,
      knownLanguages = List("JavaScript")),
    Programmer(name = "John",
      level = Level.Senior,
      knownLanguages = List("Java", "Scala", "Kotlin")),
    Programmer(name = "Dave",
      level = Level.Junior,
      knownLanguages = List("C", "C++"))
  )

  def isMidOrSenior(implicit counter: AtomicInteger): Programmer => Boolean =
    programmer => {
      counter.incrementAndGet()
      println("verify level " + programmer)
      List(Level.Mid, Level.Senior).contains(programmer.level)
    }

  def knowsMoreThan1Language(implicit counter: AtomicInteger): Programmer => Boolean =
    programmer => {
      counter.incrementAndGet()
      println("verify number of known languages " + programmer)
      programmer.knownLanguages.size > 1
    }

  val getName: Programmer => String =
    programmer => {
      println("get name " + programmer)
      programmer.name
    }
}
sealed trait Level
object Level {
  case object Junior extends Level
  case object Mid extends Level
  case object Senior extends Level
}
case class Programmer(name: String,
                      level: Level,
                      knownLanguages: List[String])

