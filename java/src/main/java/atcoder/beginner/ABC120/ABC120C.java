package atcoder.beginner.ABC120;

import java.util.LinkedList;
import java.util.Scanner;

public class ABC120C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    ABC120C abc120C = new ABC120C();
    System.out.println(abc120C.solve(S));
  }

  public int solve(String S) {
    ABC120CSolve abc120CSolve = new ABC120CSolve();
    return abc120CSolve.solve(S);
  }

  class ABC120CSolve {
    static final int ZERO = (int) '0';

    public int solve(String S) {
      int ans = 0;
      LinkedList<Integer> list = new LinkedList();

      for (char c : S.toCharArray()) {
        int i = (int) c - ZERO;
        if (list.size() == 0) {
          list.addLast(i);
        } else {
          if (list.getLast() != i) {
            list.removeLast();
            ans += 2;
          } else {
            list.addLast(i);
          }
        }
      }
      return ans;
    }
  }
}
