package atcoder.beginner.q149

object QE {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)

    val n = sc.nextInt()
    val m = sc.nextLong()
    val a = Array.fill(n)(sc.nextLong()).sorted(Ordering.Long.reverse)

    val qe = new QE(n, m, a)

    println(qe.ans)
  }
}

class QE(n: Int, m: Long, a: Array[Long]) {
  private val r = Array.fill(n)(0L)
  r(0) = a.head
  for (i <- 1 until n) {
    r(i) = r(i - 1) + a(i)
  }

  def searchIndex(p: Long) = {
    if (p > a.head) {
      -1
    } else if (p <= a.last) {
      a.length - 1
    } else {
      var left = 0
      var right = a.length
      while (left < right) {
        val mid = (left + right) / 2
        if (a(mid) < p) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      left - 1
    }
  }

  def numHandShake(p: Long) = {
    a.foldLeft(0L) { (acc, cur) =>
      acc + searchIndex(p - cur) + 1
    }
  }

  def search() = {
    var left = 0L
    var right = a.head * 2 + 1
    while (left + 1 < right) {
      val mid = (left + right) / 2
      if (numHandShake(mid) < m) {
        right = mid
      } else {
        left = mid
      }
    }
    left
  }

  def ans = {
    val p = search()
    val c = numHandShake(p)

    a.foldLeft((0L))((acc, cur) => {
      searchIndex(p - cur) match {
        case x if x >= 0 => acc + r(x) + cur * (x + 1)
        case _ => acc
      }
    }) - (c - m) * p
  }
}
