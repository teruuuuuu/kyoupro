package atcoder.beginner.ABC123;

import java.util.Scanner;

public class ABC123B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] a = new int[5];
    for (int i = 0; i < 5; i++) {
      a[i] = sc.nextInt();
    }
    ABC123B abc123B = new ABC123B();
    System.out.println(abc123B.solve(a));
  }

  public int solve(int[] a) {
    int ans = 0;
    int max_diff = 0;
    for(int i = 0; i < 5; i++ ){
      int diff = tenDiff(a[i]);
      ans += a[i] + diff;
      if(diff > max_diff){
        max_diff = diff;
      }
    }
    return ans - max_diff;
  }

  private int tenDiff(int a) {
    if (a % 10 == 0) {
      return 0;
    } else {
      return 10 - (a % 10);
    }
  }
}
