package atcoder.beginner.q165

object QB {
  import scala.io.StdIn.readLine
  def main(args: Array[String]): Unit = {
    val x = readLine.trim().toLong
    var current = 100L

    var i = 0
    while(current < x) {
      current = (current * 1.01).toLong
      i += 1
    }
    println(i)
  }
}
