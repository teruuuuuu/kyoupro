package atcoder.beginner.q111

object QB {
  import scala.io.StdIn.readLine
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit = {
    val i = input(a=>a).head.toCharArray.map(_.toInt)
    println(new QB(i).ans)
  }
}

class QB(input: Array[Int]) {
  val isBegeer = input.tail.exists(_>input.head)
  def initStr(a:Int, b:Int) ={
    (1 to b).toList.foldLeft(List(): List[Char])((acc, c) => {
      acc :+ a.toChar
    }).mkString
  }
  val ans: String = {
    isBegeer match {
      case false => initStr(input.head, input.length)
      case true => initStr(input.head+1, input.length)
    }
  }
}