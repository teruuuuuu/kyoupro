package atcoder.beginner.ABC116;

import java.util.Scanner;

public class ABC116B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    ABC116B abc116B = new ABC116B();
    System.out.println(abc116B.solve(start));
  }

  public int solve(int start) {
    ABC116BSolve abc116BSolve = new ABC116BSolve();
    return abc116BSolve.search(start);
  }

  class ABC116BSolve {

    public int search(int start) {
      boolean[] history = new boolean[1000000];
      int current = start;
      int i = 1;
      while (true) {
        if (history[current]) return i;
        history[current] = true;
        if (current % 2 == 1) {
          current = 3 * current + 1;
        } else {
          current /= 2;
        }
        i++;
      }
    }
  }
}
