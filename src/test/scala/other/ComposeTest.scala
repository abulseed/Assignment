package other

import org.scalatest.FunSuite

/**
  * Created by abulseed on 10/22/2017.
  */
class ComposeTest extends FunSuite {
  test("Compose.compose") {
    assert(Compose.h(6) === 49)
    assert(Compose.h(6) !== 50)
    assert(Compose.compose({ x: Int => x + x }, { x: Int => x + 1 })(5) === 12)
    assert(Compose.compose({ x: Int => x + x }, { x: Int => x + 1 })(5) !== 11)
  }
}
