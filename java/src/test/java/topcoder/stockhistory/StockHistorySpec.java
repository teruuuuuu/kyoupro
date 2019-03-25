package topcoder.stockhistory;

import org.junit.Test;

public class StockHistorySpec {
  @Test
  public void problem1(){
    int initialInvestment = 100;
    int monthlyContribution = 20;
    String[] stockPrices = {
            "40 50 60",
            "37 48 55",
            "100 48 50",
            "105 48 47",
            "110 50 52",
            "110 50 52",
            "110 51 54",
            "109 49 53"};
    int ans = 239;
    int result = StockHistory.maximumEarnings(initialInvestment, monthlyContribution, stockPrices);
    assert(result == ans);
  }
}
