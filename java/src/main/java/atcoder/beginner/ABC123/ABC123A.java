package atcoder.beginner.ABC123;

import java.util.Scanner;

public class ABC123A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int max = 0;
    int min = 123;
    for(int i = 0; i < 5; i++ ){
      int a = sc.nextInt();
      if(a > max){ max = a; }
      if(a < min){ min = a; }
    }
    int k = sc.nextInt();
    if(max - min > k) {
      System.out.println(":(");
    } else {
      System.out.println("Yay!");
    }
  }
}
