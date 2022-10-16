package topcoder.colorfulboxesandballs;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=10743
 */
public class ColorfulBoxesAndBalls {

  public int getMaximum(int numRed, int numBlue, int onlyRed,
                        int onlyBlue, int bothColors) {
    int ans = Integer.MAX_VALUE;
    int change = Math.min(numBlue, numBlue);
    for (int i = 0; i <= change; i++) {
      int myscore = (numRed - i) * onlyRed
        + (numBlue - i) * onlyBlue + 2 * i * bothColors;
      ans = Math.max(ans, myscore);
    }
    return ans;
  }
}
