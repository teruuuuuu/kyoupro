package atcoder.beginner.q149

object QC {
  import scala.io.StdIn.readLine

  def multi(a:Long, b:Long):Long = a * b
  def divide(a: Long, b: Long):Long = a / b
  def remain(a: Long, b: Long):Long = a % b

  def primes(max:Int): List[Int] = {
    (1 to (max / 6).toInt).foldLeft(List(2,3)){(acc,c) => {
      val a = c*6-1
      val b = c*6+1
      val sq = acc.takeWhile(a=> a <= math.sqrt(b).toInt+1)
      val k=if(sq.foldLeft(true){(acc, c) => if(acc && remain(a, c) != 0) true else false}) List(a) else List()
      val v=if(sq.foldLeft(true){(acc, c) => if(acc && remain(b, c) != 0) true else false}) List(b) else List()
      acc++k++v
    }}
  }

  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit = {
    val n = input(_.toInt).head
    val primeList = primes(n).filter(a => a <= n)
    if(n == 1 || n == 2) {
      println(n)
    } else if(primeList.lastOption.contains(n)) {
      println(n)
    } else {
      var loop = true
      var i = n
      while(loop) {
        if(primeList.find(a => i % a == 0).isEmpty) {
          println(i)
          loop = false
        }
        i = i + 1
      }
    }
  }
}
