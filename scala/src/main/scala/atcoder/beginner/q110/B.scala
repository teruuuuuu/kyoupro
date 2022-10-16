package atcoder.beginner.q110

import scala.io.StdIn.readLine

object B {
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit ={
    val a = input((a=>a.toInt))
    val x = a(2)
    val y = a(3)
    val maxX = (input((a=>a.toInt)) :+ x).sortBy(a=>a).last
    val minY = (input((a=>a.toInt)) :+ y).sortBy(a=>a).head
    if(maxX >= minY) {
      println("War")
    } else {
      println("No War")
    }
  }
}
