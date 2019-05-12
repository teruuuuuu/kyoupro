package atcoder.beginner.ABC123;

import java.util.Arrays;
import java.util.Scanner;

public class ABC123D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int z = sc.nextInt();
    int k = sc.nextInt();
    long[] a = new long[x];
    long[] b = new long[y];
    long[] c = new long[z];
    for (int i = 0; i < x; i++) {
      a[i] = sc.nextLong();
    }
    for (int i = 0; i < y; i++) {
      b[i] = sc.nextLong();
    }
    for (int i = 0; i < z; i++) {
      c[i] = sc.nextLong();
    }
    ABC123D abc123D = new ABC123D();
    for (long i : abc123D.solve(a, b, c, k)) {
      System.out.println(i);
    }
  }

  public long[] solve(long[] a, long[] b, long[] c, int k) {
    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);
    int index = 0;
    long[] ab = new long[Math.min(k, a.length) * Math.min(k, b.length)];
    for (int i = Math.max(0, a.length - k); i < a.length; i++) {
      for (int j = Math.max(0, b.length - k); j < b.length; j++) {
        ab[index] = a[i] + b[j];
        index += 1;
      }
    }
    Arrays.sort(ab);
    index = 0;
    long[] abc = new long[Math.min(k, ab.length) * Math.min(k, c.length)];
    for (int i = Math.max(0, ab.length - k); i < ab.length; i++) {
      for (int j = Math.max(0, c.length - k); j < c.length; j++) {
        abc[index] = ab[i] + c[j];
        index += 1;
      }
    }
    Arrays.sort(abc);
    long[] ans = new long[k];
    index = 0;
    for (int i = abc.length - 1; i >= Math.max(abc.length - k, 0); i--) {
      ans[index] = abc[i];
      index += 1;
    }
    return ans;
  }
}
