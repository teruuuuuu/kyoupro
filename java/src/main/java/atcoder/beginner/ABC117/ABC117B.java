package atcoder.beginner.ABC117;

import java.util.Scanner;

public class ABC117B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] l = new int[N];
    for(int i = 0; i < N; i++){
      l[i] = sc.nextInt();
    }
    ABC117B abc117B = new ABC117B();
    if(abc117B.solve(l)){
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  public boolean solve(int[] l) {
    int max = 0;
    int sum = 0;
    for(int i = 0; i < l.length; i++ ){
      if(l[i] > max ) {
        sum += max;
        max = l[i];
      } else {
        sum += l[i];
      }
    }
    return sum > max;
  }
}
