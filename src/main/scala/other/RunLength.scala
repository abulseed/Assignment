package other

import scala.annotation.tailrec

/**
  * Created by abulseed on 10/22/2017.
  */
object RunLength {

  def runLengthEncode(text: String): List[(Int, Char)] = {
    @tailrec
    def iter(result: List[(Int, Char)], chars: List[Char]): List[(Int, Char)] =
      chars match {
        case Nil => result
        case cs => {
          val right: List[Char] = cs.takeWhile({ c => cs.headOption.contains(c) })
          iter(result ::: List((right.length, right.head)), cs.drop(right.length))
        }
      }

    iter(List[(Int, Char)](), text.toList)
  }

  def runLengthDecode(list: List[(Int, Char)]): String = list match {
    case Nil => ""
    case ls => {
      var result: String = ""
      def decodeEntry(occ: Int, value: Char) = {
        for (i <- 1 to occ) result = result + value
      }

      for ((occ, value) <- list) decodeEntry(occ, value)
      result
    }
  }
}
