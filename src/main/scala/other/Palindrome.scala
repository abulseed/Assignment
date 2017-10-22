package other

import scala.annotation.tailrec

/**
  * Created by abulseed on 10/22/2017.
  */
object Palindrome {
  def isPalindrome(text: String): Boolean = {
    @tailrec
    def iter(result: Boolean, chars: List[Char]): Boolean = chars match {
      case Nil => result
      case c :: cs => {
        if (!cs.takeRight(1).headOption.contains(c))
          iter(false, Nil)
        else
          iter(true, cs.dropRight(1))
      }
    }
    iter(false, normalizeInput(text.toList))
  }

  def normalizeInput(chars: List[Char]): List[Char] = chars match {
    case Nil => chars
    case cs => if (cs.length % 2 != 0) {
      val (right, left) = cs.splitAt(cs.length / 2)
      right ::: left.tail
    } else
      cs
  }
}
