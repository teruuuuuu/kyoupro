package atcoder.beginner.ABC149;

import java.util.Arrays;
import java.util.Scanner;

public class ABC149E {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long m = sc.nextLong();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) a[i] = sc.nextLong();
    Arrays.sort(a);

    long left = 0;
    long right = a[n - 1] * 2 + 1;
    while (left < right) {
      long mid = (left + right) / 2;
      long c = numberOfHandshake(mid, a);
      if (c <= m) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    long c = numberOfHandshake(left, a);
    long h = totalHappiness(left, a);
    if (c < m) {
      h += (left - 1) * (m - c);
    }
    System.out.println(h);
  }


  public static long numberOfHandshake(long x, long[] a) {
    int n = a.length;
    long ret = 0;
    for (int i = 0; i < n; i++) {
      ret += n - lowerbound(x - a[i], a);
    }
    return ret;
  }

  public static long totalHappiness(long x, long[] a) {
    int n = a.length;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    long ret = 0;
    for (int i = 0; i < n; i++) {
      int idx = lowerbound(x - a[i], a);
      ret += sum[n] - sum[idx] + (n - idx) * a[i];
    }
    return ret;
  }


  public static int lowerbound(long value, long[] arr) {
    int n = arr.length;
    int left = 0;
    int right = arr.length;
    if (arr[n - 1] < value) {
      return n;
    }
    if (arr[0] >= value) {
      return 0;
    }
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < value) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
