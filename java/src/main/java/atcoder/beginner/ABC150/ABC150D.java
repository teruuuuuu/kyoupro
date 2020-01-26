package atcoder.beginner.ABC150;

import java.util.Scanner;

public class ABC150D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long m = sc.nextLong();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }

    ABC150D abc150D = new ABC150D();
    System.out.println(abc150D.solve(m, a));
  }

  public Long solve(long m, long[] a) {
    long multi = 1L;
    for (int i = 0; i < a.length; i++) {
      multi = lcm(multi, a[i] / 2);
    }
    for (int i = 0; i < a.length; i++) {
      if (multi % a[i] == 0) {
        return 0L;
      }
    }
    long ret = 0L;
    for (int i = 1; i <= m / multi; i++) {
      if (i % 2 == 1) {
        ret += 1L;
      }
    }
    return ret;
  }

  private long lcm(long a, long b) {
    if(b > a) {
      return lcm(b, a);
    }
    return a / gcd(a, b) * b;
  }

  private long gcd(long a, long b) {
    if (b > a) {
      return gcd(b, a);
    }
    if (a == b) {
      return a;
    }
    long ret = a;
    while(b != 0) {
      ret = b;
      b = a % b;
      a = ret;
    }
    return ret;
  }

  private long multiplue(long a, long b) {
    long ret = a > b ? a : b;
    long unit = a > b ? a : b;
    long base = a > b ? b : a;
    while (ret % base != 0) {
      ret += unit;
    }
    return ret;
  }
}
