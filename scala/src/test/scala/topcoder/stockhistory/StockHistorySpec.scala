package topcoder.stockhistory

import org.scalatest.{DiagrammedAssertions, FunSpec}

class StockHistorySpec extends FunSpec with DiagrammedAssertions {
  describe("StockHistory") {
    it("q1") {
      val initialInvestment = 100
      val monthlyContribution = 20
      val stockPrices = Array(
        "40 50 60",
        "37 48 55",
        "100 48 50",
        "105 48 47",
        "110 50 52",
        "110 50 52",
        "110 51 54",
        "109 49 53")
      val ans = 239
      assert(StockHistory.maximumEarnings(initialInvestment, monthlyContribution, stockPrices) == ans)
    }
  }
}
