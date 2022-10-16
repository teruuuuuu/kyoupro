package topcoder.stockhistory;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=3971&rd=6521
 */
public class StockHistory {
  public static int maximumEarnings(int initialInverstment, int monthlyContribution, String[] stockPrices) {
    int month = stockPrices.length;
    int corp = stockPrices[0].split(" ").length;

    int[][] prices = new int[month][corp];
    double max = 0;
    double profit = 0;
    double[] propertion = new double[month - 1];
    boolean[] buy = new boolean[month - 1];

    for (int i = 0; i < month; i++) {
      String[] s = stockPrices[i].split(" ");
      for (int j = 0; j < s.length; j++) {
        prices[i][j] = Integer.valueOf(s[j]);
      }
    }

    for (int i = month - 2; i >= 0; i--) {
      for (int j = 0; j < corp; j++) {
        double p = 1.0 * prices[month - 1][j] / prices[i][j] - 1.0;
        if(0 < p && max < p) {
          buy[i] = true;
          max = p;
          propertion[i] = p;
        }
      }
    }

    int money = initialInverstment;
    for(int i = 0; i < buy.length; i++ ) {
      if(buy[i]) {
        profit += money * propertion[i];
        money = 0;
      }
      money += monthlyContribution;
    }
    return (int)Math.round(profit);
  }
}