package atcoder.beginner.ABC121;

import java.util.Arrays;
import java.util.Scanner;

public class ABC122C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }
    ABC122C abc122C = new ABC122C();
    System.out.println(abc122C.solve(N, M, A, B));
  }

  public long solve(int N, int M, int[] A, int[] B) {
    long ans = 0;
    Store[] Stores = new Store[N];
    for (int i = 0; i < N; i++) {
      Stores[i] = new Store(A[i], B[i]);
    }
    Arrays.sort(Stores);
    for (int i = 0; i < N; i++) {
      int num = M > Stores[i].num ? Stores[i].num : M;
      ans += (long) num * Stores[i].price;
      M -= num;
      if(M == 0) break;
    }
    return ans;
  }

  class Store implements Comparable<Store> {
    int price;
    int num;
    public Store(int price, int num){
      this.price = price;
      this.num = num;
    }
    @Override
    public int compareTo(Store other) {
      return this.price - other.price;
    }
  }
}
