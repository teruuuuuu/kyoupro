package atcoder.beginner.q111

import org.scalatest.{FlatSpec, Matchers}

class QDSpec extends FlatSpec with Matchers {


  "QDSpec" should "test 1" in {
    new QD(31, List((3,1))).bitExpand(0) shouldEqual List()
    new QD(31, List((3,1))).bitExpand(1) shouldEqual List(true)
    new QD(31, List((3,1))).bitExpand(2) shouldEqual List(false, true)
    new QD(31, List((3,1))).bitExpand(3) shouldEqual List(true, true)
    new QD(31, List((3,1))).bitExpand(7) shouldEqual List(true, true, true)
    new QD(31, List((3,1))).bitExpand(8) shouldEqual List(false, false, false, true)
  }

  "QDSpec" should "test 2" in {
    println(new QD(5, List((7,2))).solver((7, 2)))
    println(new QD(5, List((7,2))).solverTest("LDULR"))

    println(new QD(5, List((3,2))).solver((2, 1)))
    println(new QD(5, List((3,2))).solverTest("ULLLR"))
  }
}
