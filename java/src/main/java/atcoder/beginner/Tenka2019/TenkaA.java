package atcoder.beginner.Tenka2019;

import java.util.Scanner;

public class TenkaA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    if((a < c && c < b) || (b < c && c < a)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
