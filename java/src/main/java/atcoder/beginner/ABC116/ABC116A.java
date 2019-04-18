package atcoder.beginner.ABC116;

import java.util.Arrays;
import java.util.Scanner;

public class ABC116A {

  public static void main(String[] args) {
    ABC116A abc116A = new ABC116A();
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int z = sc.nextInt();
    System.out.println(abc116A.solve(x, y, z));

  }

  public int solve(int x, int y, int z) {
    int[] a = {x, y, z};
    Arrays.sort(a);
    return a[0] * a[1] / 2;
  }

}

