package Scala_Concepts

object Self {
  def main(args: Array[String]): Unit = {

  }
  trait Edible
  // person hierarchy
  trait Person {
    def hasAllergiesFrom(thing: Edible): Boolean
  }
  trait Child extends Person
  trait Adult extends Person

  // diet hierarchy
  trait Diet { self: Person =>
    def eat(thing: Edible): Boolean =
      if (self.hasAllergiesFrom(thing)) false
      else true
  }
  //    trait Carnivore extends Diet with Person
  //    trait Vegetarian extends Diet with Person


  // option 1
  // trait Diet extends Person

  // This option makes all the (non-private) Person functionality available to Diet.
  // However, this obviously makes a mess out of two otherwise clean and separate concept hierachies.

  // option 2
  // trait Diet[P <: Person]

  // option 3
  //  trait Diet { self: Person =>
  //
  //  }

  //  When you see something like this in a class or trait definition, you need to read it as
  //  “whichever class implements the Diet trait MUST ALSO implement the Person trait”.

  //  class VegAthlete extends Vegetarian with Adult


  //  Inheritance VS Self-Type
  //  class Dog extends Animal
  //  This means Dog IS AN Animal


  //  trait Diet { self: Person =>}
  //  Diet REQUIRES A Person


}
