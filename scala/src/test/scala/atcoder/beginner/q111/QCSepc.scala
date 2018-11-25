package atcoder.beginner.q111

import org.scalatest.{FlatSpec, Matchers}

class QCSpec extends FlatSpec with Matchers {
  def makeList(n: Int, m: Int): Array[Int] = (1 to n).foldLeft(Array(): Array[Int])((acc, c) => acc :+ c % m)

  "QCSpec" should "test 1" in {
    val t0 = System.currentTimeMillis()
    val n = math.pow(10, 5).toInt
    val input = (1 to math.pow(10, 5).toInt).map(_%10).toList
    val ans = new QC(n, input).ans
    println(ans)
    val t1 = System.currentTimeMillis()
    println("Elapsed time: " + (t1 - t0) + "ms")
    ans shouldEqual "80000"
  }

  "QCSpec" should "test 2" in {
//    val a1 = makeList(math.pow(10, 5).toInt/2, 1).toList
//    val a2 = makeList(math.pow(10, 5).toInt/2, 1).toList
//    val t0 = System.currentTimeMillis()
//    val ans = new QC((a1, a2)).ans
//    println("ans:" + ans)
//    val t1 = System.currentTimeMillis()
//    println("Elapsed time: " + (t1 - t0) + "ms")
//    ans shouldEqual "50000"
  }

}
