package topcoder.autoloan;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=3970&rd=7993
 */
public class AutoLoan {

  public double interestRate(double price, double monthyPayment, int loanTearm) {
    double balance;
    double high = 100, low = 0, mid = 0;
    while (1e-9 < high - low // 絶対誤差
      && 1e-9 < (high - low) / high) {// 相対誤差
      balance = price;
      mid = (high + low) / 2;

      for (int i = 0; i < loanTearm; i++) {
        balance *= mid / 1200 + 1;
        balance -= monthyPayment;
      }
      if (0 < balance) high = mid;
      else low = mid;
    }
    return mid;
  }
}
