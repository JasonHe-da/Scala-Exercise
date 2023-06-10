package Mini_Sudoku

object Sudoku {
  def main(args: Array[String]): Unit = {
    type board = Array[Array[Int]]
    def prettyString(sudoku: board): String = sudoku.map(row => row.mkString(" ")).mkString("\n")
    def validate(sudoku: board, x: Int, y: Int, value: Int): Boolean = {

      // obtain the row
      val row = sudoku(y)

      // obtain the column
      // equivalent code val column = sudoku.map(_.apply(x))
      val column = sudoku.map(elem => elem(x))

      // obtain the box
      // let's say we are at  row 3 column 4
      // 1,1 box
      // row 3,4,5 column 3,4,5

      val box_X = x / 3
      val box_Y = y / 3

      val box = for {
        yb <- (box_Y * 3) until( box_Y * 3 + 3)
        xb <- (box_X * 3) until( box_X * 3 + 3)

      } yield sudoku(yb)(xb)


      val validator = value match {
        case i if row.contains(i) => true
        case i if column.contains(i) => true
        case i if box.contains(i) => true
        case _ => false
      }

      validator
    }

    def solve(sudoku: board, x:Int = 0, y:Int = 0):Unit = {
      if(y>= 9) println(prettyString(sudoku))
      else if (x >= 9) solve(sudoku, 0, y+1)
      else if (sudoku(y)(x)>0) solve(sudoku, x + 1, y)

      else (1 to 9).foreach(
        elem =>
          if (!validate(sudoku, x, y, elem)) {
            sudoku(y)(x) = elem
            solve(sudoku, x + 1, y)
            sudoku(y)(x) = 0

          }

      )
    }


    val problem = Array(Array(5,3,0,0,7,0,0,0,0),
                        Array(6,0,0,1,9,5,0,0,0),
                        Array(0,9,8,0,0,0,0,6,0),
                        Array(8,0,0,0,6,0,0,0,3),
                        Array(4,0,0,8,0,3,0,0,1),
                        Array(7,0,0,0,2,0,0,0,6),
                        Array(0,6,0,0,0,0,2,8,0),
                        Array(0,0,0,4,1,9,0,0,5),
                        Array(0,0,0,0,8,0,0,7,9),
                        )
//    println(validate(problem,1, 1, 2))

    solve(problem)
  }

}
