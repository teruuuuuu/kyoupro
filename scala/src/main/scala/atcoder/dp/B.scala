package atcoder.dp
// https://atcoder.jp/contests/dp/tasks/dp_b

object B {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val k = sc.nextInt
    val h: Array[Int] = Array.fill(n)(0)
    val dp: Array[Long] = Array.fill(n)(0)
    for (i <- 0 until n) h(i) = sc.nextInt()
    for (i <- 1 to Math.min(k, n - 1)) {
      dp(i) = Math.abs(h(i) - h(0))
    }
    for (i <- 1 until n - 1) {
      if (i + k <= n - 1) dp(i + k) = dp(i) + Math.abs(h(i + k) - h(i))
      for (j <- 1 until Math.min(k, n - i)) {
        dp(i + j) = Math.min(dp(i + j), dp(i) + Math.abs(h(i) - h(i + j)))
      }
    }
    println(dp(n-1))
  }
}

//object Main extends App {
//  val Array(n, k) = readLine.split(" ").map(_.toInt)
//  val h = readLine.split(" ").map(_.toInt)
//
//  val dp = Array.fill(n)(Int.MaxValue)
//  dp(0) = 0
//  for (i <- 0 until n; j <- 1 to k if (i + j) < n) {
//    dp(i + j) = math.min(dp(i + j), dp(i) + math.abs(h(i) - h(i + j)))
//  }
//  println(dp(n - 1))
//}
