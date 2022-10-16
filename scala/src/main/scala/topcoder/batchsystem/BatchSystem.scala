package topcoder.batchsystem

import scala.io.StdIn.readLine

object BatchSystem {
  def input[A](change: String => A) = readLine.split(" ").map(change(_))
  def main(args : Array[String]): Unit = {
    val durations: Array[Int] = input((a=>a.toInt)).toArray
    val users: Array[String] = input((_.toString)).toArray

    schedule(durations, users).foreach(print)
  }

  def schedule(durations : Array[Int], users: Array[String]): Array[Int] = {
    val usersIndex = users.zipWithIndex.foldLeft(Map.empty[String, List[Int]])((acc, cur) => {
      acc.updated(cur._1, acc.get(cur._1).getOrElse(List.empty[Int]) :+ cur._2)
    })
    users.zip(durations).foldLeft(Map.empty[String, Int])((acc, cur) => {
      acc.updated(cur._1, acc.getOrElse(cur._1, 0) + cur._2)
    }).toList.sortBy(_._2).
      flatMap(u => usersIndex.getOrElse(u._1, List())).toArray
  }
}
