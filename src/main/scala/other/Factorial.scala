package other

import scala.annotation.tailrec

/**
  * Created by abulseed on 10/22/2017.
  */
object Factorial {

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0) result
      else
        iter(x - 1, result * x)

    iter(n, 1)
  }
}
