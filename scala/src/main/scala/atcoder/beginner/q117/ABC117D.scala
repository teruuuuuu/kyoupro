package atcoder.beginner.q117

object ABC117D {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val K = sc.nextLong
    var A = List.empty[Long]
    (1 to N).foreach { f =>
      A = A :+ sc.nextLong
    }
    val abc117d = new ABC117D(N, K, A)
    println(abc117d.solve)
  }
}

class ABC117D(N: Int, K: Long, A: Seq[Long]) {

  def solve(): Long = {
    val N2 = N / 2
    var defaultBits = ~0L
    var xorBits = List.empty[Long]
    var bitsOn = List.empty[Boolean]
    var b = 1L
    while(K >= b) {
      xorBits = xorBits :+ b
      if ((K & b) > 0) bitsOn = bitsOn :+ true
      else bitsOn = bitsOn :+ false
      defaultBits = defaultBits ^ b;
      b = b << 1;
    }
    val bitLen = xorBits.length
    val bitsAggregate = Array.ofDim[Int](bitLen)

    var defaultSum = 0L
    A.foreach{ a =>
      defaultSum += defaultBits & a
      (0 to bitLen).foreach(i=> {
        if(((a >> i) & 1) == 1) {bitsAggregate(i) += 1}
      })
    }
    var sum1 = 0L
    var sum2 = 0L
    b = 1L
    bitsAggregate.zipWithIndex.foreach{
      case (x, i) => {
        val bitOff = x <= N2
        if (bitsOn(i) && bitOff) {sum1 += b * (N - bitsAggregate(i))}
        else {sum1 += b * bitsAggregate(i)}

        if (bitOff && i < bitLen - 1) {sum2 += b * (N - bitsAggregate(i))}
        else {sum2 += b * bitsAggregate(i)}
        b = b << 1
      }
    }

    if (sum1 > sum2) defaultSum + sum1
    else defaultSum + sum2
  }
}
