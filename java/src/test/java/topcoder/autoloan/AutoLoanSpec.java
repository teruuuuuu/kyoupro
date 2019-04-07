package topcoder.autoloan;

import org.junit.Test;

public class AutoLoanSpec {

  @Test
  public void test() {
    double price = 2000;
    double monthyPayment = 510;
    int loanTearm = 4;
    double ans = 9.56205462458368;
    AutoLoan al = new AutoLoan();
    double result = al.interestRate(price, monthyPayment, loanTearm);
    double abs = Math.abs(ans - result);
    double rel = abs / Math.max(ans, result);
    assert(abs < 1e-9 || rel < 1e-9);
  }
}
