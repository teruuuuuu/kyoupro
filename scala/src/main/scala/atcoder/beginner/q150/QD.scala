package atcoder.beginner.q150

import scala.annotation.tailrec

object QD {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)

    val m = sc.nextLine().split(" ").map(_.toLong).last
    val a = sc.nextLine().split(" ").map(_.toLong)

    println(QDAns.solve(m, a))
  }
}

object QDAns {

  def solve(m: Long, a: Array[Long]): Long = {
    val v = a.foldLeft(1L)((acc, cur) => lcm(acc, cur/ 2))
    a.find(v % _ == 0) match {
      case Some(_) => 0L
      case _ => Math.ceil((m/v)/2.0).toLong
    }
  }

  private def lcm(a: Long, b: Long): Long = {
    if(b > a) {
      lcm(b, a)
    } else {
      a / gcd(a, b) * b
    }
  }

  private def gcd(a: Long, b: Long): Long = {
    @tailrec
    def gcdLoop(c: Long, d: Long):Long = {
      if(d == 0) {
        c
      } else {
        gcdLoop(d, c % d)
      }
    }

    if(b > a) {
      gcd(b, a)
    } else if(a == b) {
      a
    } else {
      gcdLoop(a, b)
    }
  }
}
