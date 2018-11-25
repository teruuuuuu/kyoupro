package atcoder.beginner.q111

object QC {
  import scala.io.StdIn.readLine
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val v = List.fill(n)(sc.nextInt)

    println(new QC(n, v).ans)
  }
}

class QC(n: Int, input: List[Int]) {
  val s1 = n/2+n%2
  val s2 = n/2
  var m1:Map[Int, Int] = Map()
  var m2:Map[Int, Int] = Map()
  def countUp(m: Map[Int, Int], k: Int) = m.getOrElse(k,0)+1
  input.zipWithIndex.foreach{case (v, idx) => {
    if(idx%2==1){ m1 += v -> countUp(m1,v)}
    else { m2 += v -> countUp(m2,v) }
  }}

  def ans():String = {
    val ms1:Seq[(Int, Int)] = m1.toSeq.sortBy(-_._2)
    val ms2:Seq[(Int, Int)] = m2.toSeq.sortBy(-_._2)
    (ms1.head._1 != ms2.head._1) match {
      case true =>
        (s1-ms1.head._2) + (s2-ms2.head._2)
      case false =>
        val k = (s1-ms1.head._2) + (s2-ms2.tail.headOption.getOrElse((0,0))._2)
        val l = (s1-ms1.tail.headOption.getOrElse((0,0))._2) + (s2-ms2.head._2)
        if (k<l){k} else {l}
    }
  }.toString()
}
