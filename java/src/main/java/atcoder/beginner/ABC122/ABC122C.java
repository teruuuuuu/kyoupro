package atcoder.beginner.ABC122;

import java.util.Scanner;

public class ABC122C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    String S = sc.next();
    int[] l = new int[Q];
    int[] r = new int[Q];
    for (int i = 0; i < Q; i++) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }
    ABC122C abc122C = new ABC122C();
    abc122C.solve(S, N, Q, l, r);
  }

  public void solve(String S, int N, int Q, int[] l, int[] r) {
    int[] dp = new int[N];
    for (int i = 0; i < N - 1; i++) {
      if (S.charAt(i) == 'A' && S.charAt(i + 1) == 'C') {
        dp[i + 1] = dp[i] + 1;
      } else {
        dp[i + 1] = dp[i];
      }
    }
    for (int i = 0; i < Q; i++) {
      System.out.println(dp[r[i]-1] - dp[l[i]-1]);
    }
  }
}
