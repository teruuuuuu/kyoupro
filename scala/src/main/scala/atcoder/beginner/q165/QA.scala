package atcoder.beginner.q165

object QA {
  import scala.io.StdIn.readLine
  def main(args: Array[String]): Unit = {
    val k = readLine.trim().toInt
    val ab = readLine.split(" ").map(_.toInt)
    val a = ab(0)
    val b = ab(1)

    if((k - (a % k)) % k <= b - a) {
      println("OK")
    } else {
      println("NG")
    }
  }
}
