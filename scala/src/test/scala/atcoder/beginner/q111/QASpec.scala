package atcoder.beginner.q111

import org.scalatest._

class QASpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    new QA(Array('1', '1', '1')).ans shouldEqual "999"
  }
}
