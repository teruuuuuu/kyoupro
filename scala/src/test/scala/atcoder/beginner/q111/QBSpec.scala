package atcoder.beginner.q111

import org.scalatest._

class QBSpec extends FlatSpec with Matchers {
  "QBSpec" should "test 1" in {
    val ans1 = new QB(Array('2'.toInt, '3'.toInt, '2'.toInt)).ans
    ans1 shouldEqual "333"
  }

  "QBSpec" should "test 2" in {
    val ans1 = new QB(Array('3'.toInt, '3'.toInt, '3'.toInt)).ans
    ans1 shouldEqual "333"
  }
}
