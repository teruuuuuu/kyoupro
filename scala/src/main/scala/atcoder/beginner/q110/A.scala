package atcoder.beginner.q110

import scala.io.StdIn.readLine

object A {
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit ={
    val N = input((a=>a.toInt))
    val M = N.sortBy(a=>a)
    println(M.tail.foldLeft(M.head, 1)((acc, c) => (acc._1+c*acc._2, acc._2*10))._1)
  }
}
