package atcoder.beginner.ABC121;

import java.util.Scanner;

public class ABC121A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int W = sc.nextInt();
    int h = sc.nextInt();
    int w = sc.nextInt();
    System.out.println((H-h)*(W-w));
  }
}
