object P02_Scala {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,1,2,5,8)
    def Find_the_last_element_but_one_element_of_a_list(l: List[Int]): Int = {
      if(l.length >= 2){
        l(l.length - 2)
      }else if(l.length == 1){
        l.last
      }else{
        throw new NoSuchElementException
      }
    }

    println(Find_the_last_element_but_one_element_of_a_list(list1))
  }

}
