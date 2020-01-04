package atcoder.beginner.q149

// TODO: WA
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
  r(0) = a(0)
  for (i <- 1 until n) {
    r(i) = r(i - 1) + a(i)
  }
  private val vb = a.zipWithIndex.foldLeft(Map.empty[Long, Int])((acc, cur) =>
    acc + (cur._1 -> cur._2)
  )

  def findIndex(v: Long): Int = {
    def findIndex(left: Int, right: Int, v: Long): Int = {
      if (right - left > 1) {
        val mid = left + (right - left) / 2
        if (a(mid) >= v) {
          findIndex(mid, right, v)
        } else {
          findIndex(left, mid, v)
        }
      } else {
        if(a(right) >= v) {
          vb(a(right))
        } else {
          vb(a(left))
        }
      }
    }

    if(a.head >= v) {
      findIndex(0, n - 1, v)
    } else {
      -1
    }
  }

  def findVal(): Long = {
    def findVal(left: Long, right: Long): Long = {
      if (right - left > 1) {
        val mid = left + (right - left) / 2

        var count = 0
        a.foreach { i =>
          findIndex(mid - i) match {
            case v if v >= 0 => {
              count = count + v + 1
            }
            case _ => {}
          }
        }
        if (count >= m) {
          findVal(mid, right)
        } else {
          findVal(left, mid)
        }
      } else left
    }

    findVal(0, Math.pow(10, 5).toInt * 2 + 1)
  }

  def search(): Long = findVal()

  def ans: Long = {
    val x = search()

    val ret = a.foldLeft((0L, 0L))((acc, cur) => {
      val v = x - cur
      findIndex(v) match {
        case i if i >= 0 => (acc._1 + r(i) + cur * (i + 1), acc._2 + i + 1)
        case _ => acc
      }
    })
    ret._1 + (m - ret._2) * x
  }
}
