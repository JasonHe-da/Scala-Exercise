package PatternMatching

object MatchCollection {
  def main(args: Array[String]): Unit = {
    for(arr <- List(
      Array(0), Array(1,0), Array(0,1,0),Array(1,1,0),Array(2,3,7,15), Array("0,1",0)
    )){
      val result = arr match{
        case Array(0) => "0"
        case Array(1,0) => "Array(1,0)"
        case Array(_,_,_) => "Array(3 elements)"
        case Array(2,_*) => "Array(2 _*)"
        case Array(x:String,z:Int) => s"Array(${x} ${z})"
        case _ => "whatever"
      }
    //      println(result)
    }

    for ( list <- List(
      List(0), List(1,0), List(0,0,0), List("9", 1, true)
    )){
      val result = list match{
        case List(0) => "0"
        case List(x:String, y: String, z: Boolean) => "3 different types list"
        case List(x,y) => "two elements"
        case List(0, _*) => "List starts with 0"
        case _ => "whatever"
      }
//      println(result)
    }

    val list = List(1,2,5,7,24)
    list match {
      case first :: second :: rest => println(first, second, rest)
    }

    println("========================")

    for( tuple <- List((0,1),(0,0), (0,1,0),(0,1,1), (true, "klasjdkl", 123, 'c'))){
      val result = tuple match{
        case (a,b) => " " + a + "_" + b
        case (0, _) => "start with 0"
        case (a,b,1) => "end with 1"
        case _ => "whatever"
      }
    }



  }



}
