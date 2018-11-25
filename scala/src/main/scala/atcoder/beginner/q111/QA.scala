package atcoder.beginner.q111

object QA {
  import scala.io.StdIn.readLine
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit = {
    val i = input(a=>a).head.toCharArray
    println(new QA(i).ans)
  }
}

class QA(inputs: Array[Char]) {
  val map = Map('1'->'9', '9'->'1')
  def ans(): String = {
    inputs.foldLeft(List(): List[Char])((acc, c) => {
      acc :+ ((map.contains(c)) match {
        case true => map.get(c).get
        case _ => c
      })
    }).mkString
  }
}
