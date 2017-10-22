package other

import org.scalatest.FunSuite

/**
  * Created by abulseed on 10/22/2017.
  */
class RunLengthTest extends FunSuite {
  test("RunLength.runLengthEncode") {
    assert(RunLength.runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx") === List((10, 'a'), (3, 'b'), (1, 'a'), (4, 'x'), (3, 'y'), (1, 'z'), (1, 'y'), (1, 'x')))
    assert(RunLength.runLengthEncode("aaaabbbaxxxxyyyzyx") !== List((10, 'a'), (3, 'b'), (1, 'a'), (4, 'x'), (3, 'y'), (1, 'z'), (1, 'y'), (1, 'x')))
  }
  test("RunLength.runLengthDecode") {
    assert(RunLength.runLengthDecode(List((10, 'a'), (3, 'b'), (1, 'a'), (4, 'x'), (3, 'y'), (1, 'z'), (1, 'y'), (1, 'x'))) === "aaaaaaaaaabbbaxxxxyyyzyx")
    assert(RunLength.runLengthDecode(List((10, 'a'), (3, 'b'), (1, 'a'), (4, 'x'), (3, 'y'), (1, 'z'), (1, 'y'), (1, 'x'))) !== "aaaabbbaxxxxyyyzyx")
  }
  test("RunLength.compositionOfBothMethods"){
    assert(RunLength.runLengthDecode(RunLength.runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx")) === "aaaaaaaaaabbbaxxxxyyyzyx")
  }
}
