package atcoder.beginner.ABC120;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ABC120D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; i++) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }
    ABC120D abc120D = new ABC120D();
    abc120D.solve(N, M, A, B);
  }

  public void solve(int N, int M, int[] A, int[] B) {
    ABC120DSolve abc120DSolve = new ABC120DSolve();
    long[] ans = abc120DSolve.solve(N, M, A, B);
    for (int i = 0; i < M; i++) {
      System.out.println(ans[i]);
    }
  }

  class ABC120DSolve {

    public long[] solve(int N, int M, int[] A, int[] B) {
      int[] node = IntStream.rangeClosed(0, N+1).toArray();
      int[] size = new int[N + 1];
      Arrays.fill(size, 1);
      long[] ans = new long[M];
      ans[M - 1] = (long) N * (N - 1) / 2;
      for (int i = M - 1; i > 0; i--) {
        int aRoot = root(node, A[i]);
        int bRoot = root(node, B[i]);
        if(aRoot != bRoot){
          ans[i - 1] = ans[i] - size[aRoot] * size[bRoot];
          size[bRoot] += size[aRoot];
          node[aRoot] = bRoot;
        } else {
          ans[i - 1] = ans[i];
        }

      }
      return ans;
    }

    private int root(int[] node, int i) {
      if (node[i] == i) {
        return i;
      } else {
        int ret = root(node, node[i]);
        node[i] = ret;
        return ret;
      }
    }
  }
}
