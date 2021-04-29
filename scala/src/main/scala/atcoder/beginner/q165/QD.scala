package atcoder.beginner.q165


object QD {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val a = sc.nextLong
    val b = sc.nextLong
    val n = sc.nextLong

    val x = math.min(b - 1, n)
    println(a * x / b)
  }
}

