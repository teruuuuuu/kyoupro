package atcoder.beginner.q110

import scala.io.StdIn.readLine

object D {
  def multi(a:Long, b:Long):Long = a * b
  def divide(a: Long, b: Long):Long = a / b
  def remain(a: Long, b: Long):Long = a % b

  def primes(max:Int): List[Int] = {
    (1 to (max / 6).toInt + 1).foldLeft(List(2,3)){(acc,c) => {
      val a = c*6-1
      val b = c*6+1
      val sq = acc.takeWhile(a=> a <= math.sqrt(b).toInt+1)
      val k=if(sq.foldLeft(true){(acc, c) => if(acc && remain(a, c) != 0) true else false}) List(a) else List()
      val v=if(sq.foldLeft(true){(acc, c) => if(acc && remain(b, c) != 0) true else false}) List(b) else List()
      acc++k++v
    }}
  }
  def multiper(n:Int, m:Int, c:Int):(Int, Int) = if(m % n == 0) multiper(n, m/n, c+1) else (c,m)

  def fac(l:List[Int], m:Int): List[Int] = {
    l match {
      case List() => List(1) // math.sqrt(math.pow(10,9).toInt) < math.pow(10,9)の素数が入っていることを想定
      case _ => multiper(l.head, m, 0) match {
        case (0,1) => List()
        case (x,1) => List(x)
        case (0,y) => fac(l.tail, y)
        case (x,y) => List(x) ::: fac(l.tail, y)
      }
    }
  }
  def invmod(p:Long, g:Long) = {
    def euclidean(px:Long, py:Long, pgcd: Long, x:Long, y:Long, gcd: Long):Long = {
      pgcd % gcd match {
        case 0 => (x + g) % g
        case m => {
          val d = pgcd / gcd
          euclidean(x,y,gcd, px-(d*x), py-(d*y), m)
        }
      }
    }
    euclidean(1,0,p,0,1,g)
  }
  def comb(n:Long, k:Long, p:Long):Long = {
    (1 to k.toInt).foldLeft(1.toLong)((acc,c)=> remain((multi(remain(multi(acc,(n-c+1)), p), invmod(c,p))), p))
  }
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args: Array[String]): Unit ={
    val p = math.pow(10,9).toLong + 7
    println(comb(100008,1,p))
    println(comb(100008,2,p))
    println(comb(100008,3,p))
    println(comb(100008,4,p))
    println(comb(100008,5,p))
    println(comb(100008,6,p))
    println(comb(100008,7,p))
    println(comb(100008,8,p))
    println(comb(100008,9,p))
    //    val ps = primes(math.sqrt(math.pow(10,9).toInt).toInt)
    //    val a = input((a=>a.toInt))
    //    val n = a(0)
    //    val m = a(1)
    //    val f = fac(primes(math.sqrt(p).toInt), m)
    //    val ans = f.foldLeft(1.toLong)((acc,c)=>(multi(acc, comb(c+n-1, c, p))) % p)
    //    println(ans)
  }
}
