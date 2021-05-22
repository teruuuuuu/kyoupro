package atcoder.beginner.dp;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] abc = new int[N][3];
    int[][] dp = new int[N][3];
    for (int i = 0; i < N; i++) {
      abc[i][0] = sc.nextInt();
      abc[i][1] = sc.nextInt();
      abc[i][2] = sc.nextInt();
    }
    dp[0][0] = abc[0][0];
    dp[0][1] = abc[0][1];
    dp[0][2] = abc[0][2];
    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + abc[i][0];
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + abc[i][1];
      dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + abc[i][2];
    }
    int ans = Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
    System.out.println(ans);
  }
}
