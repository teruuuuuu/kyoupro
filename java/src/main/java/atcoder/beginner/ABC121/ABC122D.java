package atcoder.beginner.ABC121;

import java.util.Scanner;

public class ABC122D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A = sc.nextLong();
    long B = sc.nextLong();
    ABC122D abc122D = new ABC122D();
    System.out.println(abc122D.solve(A, B));
  }

  public long solve(long A, long B){
    return f(A-1) ^ f(B);
  }

  private long f(long x) {
    if(x % 2 == 0){
      return x^(x/2%2);
    } else {
      return f(x+1) ^ (x+1);
    }
  }
}
