package atcoder.beginner.q149

object QD {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)

    val n = sc.nextInt()
    val k = sc.nextInt()
    val r = sc.nextInt()
    val s = sc.nextInt()
    val p = sc.nextInt()
    sc.nextLine()
    val str = sc.nextLine().toCharArray
    val qd = new QD(n, k, r, s, p)
    println(qd.ans(str))
  }
}

class QD(n: Int, k: Int, r: Long, s: Long, p: Long) {
  def judge(c: Char):Long = {
    if(c.equals('r')) {
      this.p
    } else if(c.equals('s')) {
      this.r
    } else if(c.equals('p')) {
      this.s
    } else {
      0
    }
  }

  def ans(str: Array[Char]): Long = {
    var result = 0L
    for(i <- Range(0, this.n)) {
      if(i >= k && str(i).equals(str(i-k))) {
        str(i) = '_'
      } else {
        result += judge(str(i))
      }
    }
    result
  }
}
