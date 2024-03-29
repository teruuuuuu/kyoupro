package atcoder.beginner.ABC116;

import java.util.Scanner;

public class ABC116C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] flowers = new int[N];
    for(int i = 0; i < N; i++) {
      flowers[i] = sc.nextInt();
    }

    ABC116C abc116C = new ABC116C();
    System.out.println(abc116C.solve(flowers));
  }

  public int solve(int[] flowers) {
    int ans = flowers[0];
    for(int i = 1; i < flowers.length; i++ ){
      int delta = flowers[i] - flowers[i-1];
      if(delta > 0) ans += delta;
    }
    return ans;
  }
}
