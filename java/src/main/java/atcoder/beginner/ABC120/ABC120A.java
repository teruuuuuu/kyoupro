package atcoder.beginner.ABC120;

import java.util.Scanner;

public class ABC120A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int ans;
    if(B >= A * C){
      ans = C;
    } else {
      ans = (int) B / A;
    }
    System.out.println(ans);
  }
}
