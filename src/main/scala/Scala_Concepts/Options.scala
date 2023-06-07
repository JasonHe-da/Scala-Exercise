package Scala_Concepts

object Options extends App {
  val anOption: Option[Int] = Some(42)
  val anEmptyOption: Option[Int] = None
  val aList:List[Int] = List(2)
  val aFiltered : List[Int] = aList.filter(x=>x>100)
  println(aFiltered)
  def unsafeMethod(arg: Int): String = null // implementation not important, assume that for some code path the function returns null
  // defensive code
  val potentialValue = unsafeMethod(44)
  val myRealResult =
    if (potentialValue == null)
      "ERROR"
    else
      potentialValue.toUpperCase()
  val callToExternalService = unsafeMethod(55)
  val combinedResult =
    if (potentialValue == null)
      if (callToExternalService == null)
        "ERROR 1"
      else
        "ERROR 2"
    else
      if (callToExternalService == null)
        "ERROR 3"
      else
        potentialValue.toUpperCase() + callToExternalService.toUpperCase()
  val betterCombinedResult: Option[String] = for {
    firstValue <- Option(unsafeMethod(44))
    secondValue <- Option(unsafeMethod(55))
  } yield firstValue.toUpperCase() + secondValue.toUpperCase()

  val finalValue = betterCombinedResult.getOrElse("ERROR")

  // don't write this code
  // Always use the Option “constructor”/apply method to build new Options.
  // NEVER EVER use Some(null) or Some(anExpressionThatCanBeNull), because you’ll kill us all.

  //  val myOption = None
  //  val myOption = Some(myExpression)

  // instead
  // val myOption = Option(myExpression)
}
