package other

import org.scalatest.FunSuite

/**
  * Created by abulseed on 10/22/2017.
  */
class FactorialTest extends FunSuite {
  test("Factorial.factorial") {
    assert(Factorial.factorial(3) === 6)
    assert(Factorial.factorial(3) !== 7)
  }
}
