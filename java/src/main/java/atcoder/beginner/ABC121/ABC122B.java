package atcoder.beginner.ABC121;

import java.util.Scanner;

public class ABC122B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int C = sc.nextInt();
    int[] B = new int[M];
    int[][] A = new int[N][M];
    for (int i = 0; i < M; i++) {
      B[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = sc.nextInt();
      }
    }
    ABC122B abc122B = new ABC122B();
    System.out.println(abc122B.solve(N, M, C, B, A));
  }

  public int solve(int N, int M, int C, int[] B, int[][] A) {
    int ans = 0;
    for (int[] a : A) {
      int sum = C;
      for (int i = 0; i < M; i++) {
        sum += a[i] * B[i];
      }
      if (sum > 0) ans += 1;
    }

    return ans;
  }
}
