package topcoder.badneighbors;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2402
 */
public class BadNeighbors {
  public int maxDonations(int[] donations) {
    BadNeighborsWork bn = new BadNeighborsWork();
    return bn.maxDonations(donations);
  }

  class BadNeighborsWork {
    public int maxDonations(int[] donations) {

      int ans = 0;
      int[] temp1 = new int[donations.length];
      int max1 = 0;
      for (int i = 0; i < donations.length - 1; i++) {
        if (i >= 2 && temp1[i - 2] > max1) {
          max1 = temp1[i - 2];
        }
        temp1[i] = max1 + donations[i];
        if (temp1[i] > ans)
          ans = temp1[i];
      }

      int[] temp2 = new int[donations.length];
      int max2 = 0;
      for (int i = 1; i < donations.length; i++) {
        if (i >= 2 && temp2[i - 2] > max2) {
          max2 = temp2[i - 2];
        }
        temp2[i] = max2 + donations[i];
        if (temp2[i] > ans)
          ans = temp2[i];
      }
      return ans;
    }
  }

  class BadNeighbors1 {
    public int maxDonations(int[] donations) {
      int i;
      int ans = 0;

      int N = donations.length;
      int[] dp = new int[N];

      for (i = 0; i < N - 1; i++) {
        dp[i] = donations[i];
        if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
        if(i>1) dp[i] = Math.max(dp[i], dp[i-2]+donations[i]);
        ans = Math.max(ans, dp[i]);
      }

      for (i = 0; i < N - 1; i++) {
        dp[i] = donations[i+1];
        if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
        if(i>1) dp[i] = Math.max(dp[i], dp[i-2]+donations[i+1]);
        ans = Math.max(ans, dp[i]);
      }
      return ans;
    }
  }
}
