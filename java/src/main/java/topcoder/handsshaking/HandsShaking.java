package topcoder.handsshaking;

public class HandsShaking {
  public long countPerfect(int n) {
    long[] dp = new long[n / 2 + 1];
    dp[0] = 1;
    for (int i = 1; i <= n / 2; i++) {
      dp[i] = 0;
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n / 2];
  }
}
