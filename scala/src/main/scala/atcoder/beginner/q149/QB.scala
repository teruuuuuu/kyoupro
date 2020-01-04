package atcoder.beginner.q149

object QB {
  import scala.io.StdIn.readLine

  def minus(a: Long, b: Long): (Long, Long) =  {
    if (a > b) {
      (a - b, 0)
    } else {
      (0, b - a)
    }
  }

  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit = {
    val inputs = input(_.toLong)
    val a = inputs(0)
    val b = inputs(1)
    val c = inputs(2)

    val (d,e) = minus(a,c)
    val (f,_) = minus(b,e)
    println(List(d,f).mkString(" "))
  }
}
