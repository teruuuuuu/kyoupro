package atcoder.beginner.q111

object A {
  import scala.io.StdIn.readLine
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit ={
    val k = input((a=>a.toArray.foldLeft("")((acc, c) => {
      acc + (c match {
        case '1' => "9"
        case '9' => "1"
        case _ => c.toString
      })
    }))).head
    println(k)
  }
}
