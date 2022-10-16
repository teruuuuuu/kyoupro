package topcoder.stockhistory

/**
  * https://community.topcoder.com/stat?c=problem_statement&pm=3971&rd=6521
  */
object StockHistory {
  def maximumEarnings(initialInverstment: Int, monthlyContribution: Int, stockPrices: Array[String]) = {
    var money = initialInverstment
    val stockPricesReverse = stockPrices.map(_.split(" ").map(_.toInt)).reverse
    val month = stockPricesReverse.length
    val corp = stockPricesReverse(0).length

    val lastMonthPrice = stockPricesReverse.head
    val proportion = stockPricesReverse.tail.foldLeft(0.0, List.empty[(Boolean, Double)]) {(acc, cur) => {
      cur.zip(lastMonthPrice).map{ case (c, l) => 1.0 * l/c - 1.0 }.max match {
        case x if x > acc._1 => (x, acc._2:+ (true, x))
        case x => (acc._1, acc._2:+ (false, x))
      }
    }}

    proportion._2.reverse.foldLeft(0.0){(acc, cur) =>
      if(cur._1) {
        val newAcc = acc + money * cur._2
        money = monthlyContribution
        newAcc
      } else {
        money += monthlyContribution
        acc
      }
    }.toInt
  }
}
