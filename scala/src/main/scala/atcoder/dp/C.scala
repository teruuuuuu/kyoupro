package atcoder.dp

// https://atcoder.jp/contests/dp/tasks/dp_c

object C {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val abc = Array.ofDim[Int](N, 3)
    val dp = Array.ofDim[Int](N, 3)
    for (i <- 0 until N) {
      abc(i)(0) = sc.nextInt
      abc(i)(1) = sc.nextInt
      abc(i)(2) = sc.nextInt
    }
    dp(0)(0) = abc(0)(0)
    dp(0)(1) = abc(0)(1)
    dp(0)(2) = abc(0)(2)

    for (i <- 1 until N) {
      dp(i)(0) = Math.max(dp(i - 1)(1), dp(i - 1)(2)) + abc(i)(0)
      dp(i)(1) = Math.max(dp(i - 1)(0), dp(i - 1)(2)) + abc(i)(1)
      dp(i)(2) = Math.max(dp(i - 1)(0), dp(i - 1)(1)) + abc(i)(2)
    }
    println(dp(N - 1).toList.max)
  }
}
