package atcoder.beginner.ABC124;

import java.util.Arrays;
import java.util.Scanner;

public class ABC124A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    ABC124A abc124A = new ABC124A();
    System.out.println(abc124A.solve(A, B));
  }

  public int solve(int A, int B){
    int[] array = new int[]{A, B};
    Arrays.sort(array);
    int temp = array[1];
    array[1] = array[1] - 1;
    Arrays.sort(array);
    temp += array[1];
    return temp;
  }
}
