package S_99_Scala



object P28 {
  import P10.encode
  def main(args: Array[String]): Unit = {
    // P28 (**) Sorting a list of lists according to length of sublists.
    val l = List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o'))
    val a = lsort(l)
    //    val b = lsortFreq(l)
    println(a)
  }

  //  a) We suppose that a list contains elements that are lists themselves.
  //    The objective is to sort the elements of the list according to their length.
  //    E.g. short lists first, longer lists later, or vice versa.
  def lsort[A](list: List[List[A]]) : List[List[A]] = list.sortWith(_.length < _.length )


  //  b) Again, we suppose that a list contains elements that are lists themselves.
  //    But this time the objective is to sort the elements according to their length frequency;
  //  i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.

  //  def lsortFreq[A](ls: List[List[A]]): List[List[A]] = {
  //    val freqs = Map(encode(ls map { _.length } sort { _ < _ }) map { _.swap }:_*)
  //    ls sort { (e1, e2) => freqs(e1.length) < freqs(e2.length) }
  //  }
}
