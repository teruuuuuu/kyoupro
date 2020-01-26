package atcoder.beginner.ABC150;

import java.util.Scanner;

public class ABC150B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    char[] S = sc.nextLine().toCharArray();
    ABC150B abc150B = new ABC150B();
    System.out.println(abc150B.solve(S));
  }

  public Integer solve(char[] S){
    Integer ret = 0;
    char[] a = {'A', 'B', 'C'};
    int ai = 0;
    for(int i = 0; i < S.length; i++ ){
      if(S[i] != a[ai]) {
        ai = 0;
      }
      if(S[i] == a[ai]) {
        ai++;
        if(ai >= a.length) {
          ret += 1;
          ai = 0;
        }
      }
    }
    return ret;
  }
}
