package atcoder.beginner.q111

object QD {
  import scala.io.StdIn.readLine
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val v = List.fill(n,2)(sc.nextInt).map(a=>(a(0), a(1)))
    println( new QD(31, v).ans())

  }
}

class QD(blen: Int, l: List[(Int, Int)]) {
  val hIsHorEv = (l.head._1+l.head._2).abs % 2
  val oddOrEven = l.tail.find(a=> (a._1+a._2).abs %2 != hIsHorEv) match {
    case Some(x) => Left(-1)
    case None => Right(hIsHorEv)
  }
  val bits = oddOrEven match {
    case Left(x) => List()
    case Right(x) if hIsHorEv == 1 =>
      (1 to blen).map(a=>Math.pow(2, a-1).toInt)
    case Right(x) if hIsHorEv == 0 =>
      List(1) ++ (1 to blen).map(a=>Math.pow(2, a-1).toInt)
  }

  def bitExpand(a: Long): List[Boolean] = {
    val f = (a: Long) => (a/2, a%2==1)
    lsAccum(f, (b:Long)=>b==0, a)
  }

  def lsAccum(f: Long=>(Long,Boolean), condition:Long=> Boolean, state: Long): List[Boolean] = {
    if(condition(state)) {
      List()
    } else {
      val (next, res) = f(state)
      List(res) ++ lsAccum(f, condition, next)
    }
  }

  def sigmaBit(m:Int) = {
    val sb = bitExpand((m+Math.pow(2,blen).toLong-1)/2)
    sb ++ List.fill(blen-sb.length)(false)
  }

  def solver(a:(Int, Int)):String = {
    val n = hIsHorEv match {
      case 1 => ((a._1+a._2, a._1-a._2), "")
      case 0 => ((a._1+a._2-1, a._1-a._2-1), "R")
    }
    sigmaBit(n._1._1).zip(sigmaBit(n._1._2)).foldLeft(n._2)((acc, c)=> {
      c match {
        case (true, true) => acc+"R"
        case (true, false) => acc+"U"
        case (false, true) => acc+"D"
        case (false, false) => acc+"L"
      }
    }) + "\n"
  }

  def solverTest(a: String) = {
    a.toCharArray.zip(bits).foldLeft((0, 0))((acc, c) => {
      c._1 match {
        case 'R' => (acc._1+c._2, acc._2)
        case 'U' => (acc._1, acc._2+c._2)
        case 'D' => (acc._1, acc._2-c._2)
        case 'L' => (acc._1-c._2, acc._2)
      }
    })
  }

  def ans(): String = {
    oddOrEven match {
      case Left(x) => "-1"
      case Right(x) =>
        bits.length.toString + "\n" + bits.mkString(" ") + "\n" +
          l.foldLeft("")((acc,c) => acc+solver(c))
    }
  }
}