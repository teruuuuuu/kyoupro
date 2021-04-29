package atcoder.dp

object A {
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val h: Array[Int] = Array.fill(n)(0)
    val dp: Array[Long] = Array.fill(n)(-1L)
    for (i <- 0 until n) h(i) = sc.nextInt()
    for (i <- 0 until n - 1) {
      if (i + 2 <= n - 1) dp(i + 2) = Math.max(0L, dp(i)) + Math.abs(h(i + 2) - h(i))
      Math.max(0L, dp(i)) + Math.abs(h(i + 1) - h(i)) match {
        case x if dp(i+1) > x || dp(i+1) == -1 => dp(i+1) = x
        case _ =>
      }
    }
    println(dp(n-1))
  }
}
