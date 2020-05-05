package atcoder.beginner.q165

import scala.annotation.tailrec

object QC {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val m = sc.nextInt
    val q = sc.nextInt
    val a = Array.ofDim[Int](q)
    val b = Array.ofDim[Int](q)
    val c = Array.ofDim[Int](q)
    val d = Array.ofDim[Int](q)
    (0 until q).foreach { i =>
      a(i) = sc.nextInt
      b(i) = sc.nextInt
      c(i) = sc.nextInt
      d(i) = sc.nextInt
    }

    println(new QC(n, m, q, a, b, c, d).solve)
  }
}

class QC(n: Int, m: Int, q: Int, a: Array[Int], b: Array[Int], c: Array[Int], d: Array[Int]) {
  def solve: Int = {
    val array = Array.fill[Int](n)(1)
    var ans = 0
    var break = false

    def countup(index: Int, indexUp: Boolean): Unit = {
      if (array(index) < m) {
        val next = array(index) + 1
        if (indexUp) {
          (index until n).foreach(array(_) = next)
        } else {
          array(index) = next
        }
      } else {
        countup(index - 1, true)
      }
    }

    while (!break) {
      ans = Math.max(ans, calc(array))
      break = array(0) == m
      if(!break) {
        countup(n - 1, false)
      }
    }
    ans
  }

  private def calc(array: Array[Int]) = {
    (0 until q).foldLeft(0) { (acc, cur) =>
      if (array(b(cur) - 1) - array(a(cur) - 1) equals c(cur)) {
        acc + d(cur)
      } else {
        acc
      }
    }
  }
}
