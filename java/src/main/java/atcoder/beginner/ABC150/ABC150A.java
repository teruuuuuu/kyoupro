package atcoder.beginner.ABC150;

import java.util.Scanner;

public class ABC150A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    ABC150A abc124A = new ABC150A();
    System.out.println(abc124A.solve(A, B));
  }

  public String solve(int k, int x){
    return 500 * k >= x ? "Yes" : "No";
  }
}
