package Exercise

object WordCount {
  def main(args: Array[String]): Unit = {
    val sentences = List(
      "It was the best of times, it was the worst of times.",
      "All happy families are alike; each unhappy family is unhappy in its own way.",
      "It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife.",
      "The past is a foreign country; they do things differently there.",
      "Call me Ishmael.",
      "In my younger and more vulnerable years, my father gave me some advice that I've been turning over in my mind ever since.",
      "It was a bright cold day in April, and the clocks were striking thirteen.",
      "If you really want to hear about it, the first thing you'll probably want to know is where I was born.",
      "A tale of two cities.",
      "Happy families are all alike; every unhappy family is unhappy in its own way.",
      "All animals are equal, but some animals are more equal than others.",
      "It was the age of wisdom, it was the age of foolishness.",
      "It is a truth universally acknowledged, that a single man in possession of a good fortune must be in want of a wife.",
      "It was a bright cold day in April, and the clocks were striking thirteen.",
      "It is a truth universally acknowledged, that a single man in possession of a good fortune must be in want of a wife.",
      "It was the best of times, it was the worst of times.",
      "The story so far: In the beginning, the universe was created.",
      "As Gregor Samsa awoke one morning from uneasy dreams he found himself transformed in his bed into a gigantic insect.",
      "It was a pleasure to burn.",
      "You don't know about me without you have read a book by the name of The Adventures of Tom Sawyer.",
      "Once upon a time there were four little Rabbits, and their names were Flopsy, Mopsy, Cotton-tail, and Peter.",
      "You are about to begin reading Italo Calvino's new novel, If on a winter's night a traveler.",
      "He was an old Man"
    )
    // I want to count the words and filter it out for the top three frequent ones


    // first I would flat sentences out
    val flattenList: List[String] = sentences.flatMap(
      _.split(" ")
    )

    // second I would group them if they are the same string

    val groupList: Map[String, List[String]] = flattenList.groupBy(
      sentence => sentence
    )

    // last I would pick top 3
    val frequency: List[(String, Int)] = groupList.map(kv =>
      (kv._1, kv._2.length)
    ).toList.sortWith(_._2 > _._2).take(3)


  }

}
