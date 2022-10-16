package atcoder.beginner.ABC117;

import java.util.Scanner;

public class ABC117A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int x = sc.nextInt();
    ABC117A abc117A = new ABC117A();
    System.out.println(abc117A.solve(t, x));
  }

  public double solve(int t, int x) {
    return (double) t / x;
  }
}
