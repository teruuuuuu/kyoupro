package atcoder.beginner.ABC118;

import java.util.Scanner;

public class ABC118A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    if (b % a == 0) {
      System.out.println(a + b);
    } else {
      System.out.println(b - a);
    }
  }
}
