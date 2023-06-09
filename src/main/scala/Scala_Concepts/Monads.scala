package Scala_Concepts

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
object Monads {
  def main(args: Array[String]): Unit = {

  }

  case class SafeValue[+T](private val internalValue: T) { // pure, or unit
    def get: T = synchronized {
      internalValue
    }

    def flatMap[S](transformer: T => SafeValue[S]): SafeValue[S] = synchronized { //bind, or flatMap
      transformer(internalValue)
    }

  }

  // "external" API
  def gimmeSafeValue[T](value: T): SafeValue[T] = SafeValue(value)

  val safeString: SafeValue[String] = gimmeSafeValue("Scala is awesome") // obtained from elsewhere

  // extract
  val string = safeString.get

  // transform
  val upperString = string.toUpperCase()

  // wrap
  val upperSafeString = SafeValue(upperString)

  // ETW

  val upperSafeString2 = safeString.flatMap(s => SafeValue(s.toUpperCase()))

  // EXAMPLE 1
  case class Person(firstName: String, lastName: String) {
    // you have a requirement that these fields must not be nulls
    assert(firstName != null && lastName != null)
  }

  // census API
  def getPerson(firstName: String, lastName: String): Person =
    if (firstName != null) {
      if (lastName != null) {
        Person(firstName.capitalize, lastName.capitalize)
      } else {
        null
      }
    } else {
      null
    }
  def getPersonBetter(firstName: String, lastName: String): Option[Person] =
    Option(firstName).flatMap { fName =>
      Option(lastName).flatMap { lName =>
        Option(Person(fName.capitalize, lName.capitalize))
      }
    }
  def getPersonFor(firstName: String, lastName: String): Option[Person] = for {
    fName <- Option(firstName)
    lName <- Option(lastName)
  } yield Person(fName.capitalize, lName.capitalize)

  case class User(id: String)
  case class Product(sku: String, price: Double)
  // ^ never use Double for currency IN YOUR LIFE

  def getUser(url: String): Future[User] = Future {
    User("Jason")
  }
  def getLastOrder(userId: String): Future[Product] = Future {
    Product("12302", 9.99)
  }

  val userFuture = getUser("my.store.com/users/daniel")

  userFuture.onComplete {
    case Success(User(id)) =>
      val lastOrder = getLastOrder(id)
      lastOrder.onComplete {
        case Success(Product(_, p)) =>
          val vatIncludedPrice = p * 1.19
        // then pass it on
      }
  }

  val vatIncludedPrice = getUser("my.store.com/users/daniel")
    .flatMap(user => getLastOrder(user.id)) // relevant monad bit
    .map(_.price * 1.19) // then do your thing

  val vatIncludedPriceFor = for {
    user <- getUser("my.store.com/users/daniel")
    order <- getLastOrder(user.id)
  } yield order.price * 1.19
}
