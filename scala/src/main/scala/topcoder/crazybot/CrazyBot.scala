package topcoder.crazybot

object CrazyBot {

  var k = List()

  def main(args: Array[String]): Unit ={
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val east = sc.nextInt
    val weast = sc.nextInt
    val south = sc.nextInt
    val north = sc.nextInt

    val cb = new CrazyBot(east.toDouble/100, weast.toDouble/100, south.toDouble/100, north.toDouble/100)
    println(cb.solve(n, 50, 50))
  }
}

//
class CrazyBot(east: Double, west: Double, south:Double, north: Double) {
  val dirs = List((1, 0, east), (-1, 0, west), (0, 1, south), (0, -1, north))
  val hist = Array.ofDim[Int](100, 100)

  def solve(n: Int, x: Int, y: Int): Double = {
    hist(x)(y) = 1
    val result = n match {
      case 0 => 1
      case _ => {
        var ret = 0.0
        dirs.foreach(d => {
          val nextX = x + d._1
          val nextY = y + d._2
          if(hist(nextX)(nextY) == 0) {
            ret += solve(n - 1, nextX, nextY) * d._3
          }
        })
        ret
      }
    }
    hist(x)(y) = 0
    result
  }
}