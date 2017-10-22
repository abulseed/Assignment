package other

import org.scalatest.FunSuite

/**
  * Created by abulseed on 10/22/2017.
  */
class PalindromeTest extends FunSuite {
  test("Palindrome.isPalindrome") {
    assert(Palindrome.isPalindrome("madam") === true)
    assert(Palindrome.isPalindrome("mom") === true)
    assert(Palindrome.isPalindrome("radar") === true)
    assert(Palindrome.isPalindrome("refer") === true)
    assert(Palindrome.isPalindrome("wow") === true)
    assert(Palindrome.isPalindrome("bed") === false)
    assert(Palindrome.isPalindrome("desert") !== true)
    assert(Palindrome.isPalindrome("sky") === false)
  }
}
