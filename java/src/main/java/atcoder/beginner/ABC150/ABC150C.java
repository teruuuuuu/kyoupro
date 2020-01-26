package atcoder.beginner.ABC150;

import java.util.Scanner;

public class ABC150C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] p = new int[n];
    int[] q = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      q[i] = sc.nextInt();
    }
    ABC150C abc150C = new ABC150C();
    System.out.println(abc150C.solve(n, p, q));
  }

  public Integer solve(int n, int[] p, int[] q) {
    return Math.abs(nth(p) - nth(q));
  }

  private Integer nth(int[] m) {
    Integer ret = 1;
    int[] mark = new int[m.length];
    int count;
    for (int i = 0; i < m.length; i++) {
      count = 0;
      for (int j = 0; j < m[i] - 1; j++) {
        if (mark[j] == 0) {
          count += 1;
        }
      }
      mark[m[i] - 1] = 1;
      ret += count * fact(m.length - i - 1);
    }
    return ret;
  }
  private int fact(int m) {
    int ret = 1;
    for(int i = 1; i <= m; i++ ){
      ret *= i;
    }
    return ret;
  }
}
