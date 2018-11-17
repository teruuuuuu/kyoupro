package atcoder.beginner.q110

object C {
  def main(args: Array[String]): Unit ={
    val a = readLine.toSeq
    val b = readLine.toSeq
    a.zip(b).foldLeft(Option((Map[Char,Char](),Map[Char,Char]())))((acc, c) => {
      acc match {
        case Some(x) => {
          if((x._1.contains(c._1) && !x._1.get(c._1).get.equals(c._2)) ||
            (x._2.contains(c._2) && !x._2.get(c._2).get.equals(c._1))) {
            None
          } else {
            val p = if(x._1.contains(c._1)) x._1 else x._1 + (c._1 -> c._2)
            val q = if(x._2.contains(c._2)) x._2 else x._2 + (c._2 -> c._1)
            Some(p,q)
          }
        }
        case None => None
      }
    }) match {
      case Some(x) => println("Yes")
      case None => println("No")
    }
  }
}
