package topcoder.binaryflips;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryFlips {

  /**
   * @param A 0の数
   * @param B 1の数
   * @param K 一度に裏返す数
   * @return
   */
  public int minimalFlips(int A, int B, int K) {
    BinaryFlips2 bf = new BinaryFlips2();
    return bf.minimalFlips(A, B, K);
  }


  /**
   * 愚直に全探索するパターン
   * 初期状態をリストに入れ、そこから遷移可能な状態を全て調べ、今まで出現していな状態であれば次に探索するリストに加え、
   * 0の数が0となる散策祭がなくなるまで調べる。
   */
  class BinaryFlips1 {
    public int minimalMovees(int A, int B, int K) {
      if (A == 0) return 0;
      if (A + B < K) return -1;
      int[] array = new int[A + B + 1];
      for (int i = 0; i <= A + B; i++) array[i] = -1;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(A);
      array[A] = 0;
      while (!q.isEmpty()) {
        int i = q.poll();
        for (int j = Math.max(0, K - (A + B - i));
             j <= Math.min(i, K); j++) { // jは0をひっくり返す数
          int nextzero = i + (K - 2 * j);
          if (array[nextzero] == -1) {
            if (nextzero == 0) return array[i] + 1;
            // 初めて到達する地点があれば、次の探索に加える
            array[nextzero] = array[i] + 1;
            q.add(nextzero);
          }

        }
      }
      return -1;
    }
  }

  /**
   * 計算量を減らす
   * 反転すべき0の枚数を以下のようにする
   * 0をできる限り多くする場合
   * 1をできる限り多くする場合
   * 出来るだけ0の数をkに近づける場合
   */
  class BinaryFlips2 {
    int[] array;
    int k;
    Queue<Integer> q;

    public int minimalFlips(int A, int B, int K) {
      if (A == 0) return 0;
      if (A + B < K) return -1;
      array = new int[A + B + 1];
      k = K;
      for (int i = 0; i <= A + B; i++) array[i] = -1;
      q = new LinkedList<Integer>();
      q.add(A);
      array[A] = 0;
      while (!q.isEmpty()) {
        int i = q.poll();
        check(i, Math.max(0, k - (A + B - i))); // 0をできるだけ増やす

        check(i, Math.min(i, K)); // 1をできるだけ増やす
        check(i, Math.min(Math.max((i + 1) / 2, // 0の数をKに上から近づける
          K - ((A + B) - i)), K));
        check(i, Math.min(Math.max(i / 2, // 0の数Kに下から近づける
          K - ((A + B) - i)), K));
      }
      return array[0];
    }

    public void check(int nowzero, int usezero) {
      int nextzero = nowzero + k - 2 * usezero; // 出来るだけ0を増やす 出来るだけひっくり返す1を多く
      if (array[nextzero] == -1) {
        // 初めて到達する地点であれば次の地点に加える
        array[nextzero] = array[nowzero] + 1;
        q.add(nextzero);
      }
    }
  }

  /**
   * データをうまくまとめることによって計算量を減らしたい
   * 「どこからどこまでの範囲で何手」という形式でデータを持つことができ、これを利用して
   * 0の数の最大数と最小数を1ターンごとに更新していき最小数が0になるまで繰り返すだけで
   * 最小ターン数が求めれるる
   */
  class BinaryFlips3 {
    public int minimalmoves(int A, int B, int K) {
      if (A == 0) return 0;
      if (A + B < K) return -1;
      // 0の枚数の現在の最大値、最小値を格納
      // 偶数か奇数のみしかないのに注意
      int minvalue = A, maxValue = A;
      for (int i = 0; i <= A + B; i++) {
        // まず可能な限り0を減らす -> 1をひっくり返すことを考える
        int nextMinValue, nextMaxValue;
        if (minvalue <= K && maxValue >= K) {
          // 最大値と最小値の間にKがある場合
          if (minvalue % 2 == K % 2) return i + 1; //偶奇が合えば全て1にできる
          else nextMinValue = 1; // 合わなければ、どうしても1枚0が残ってしまう
        } else {
          // その他の場合は、端だけ考えれば良い
          nextMinValue = Math.min(Math.abs(K - minvalue), Math.abs(K - maxValue));
        }

        // 同様に、最大値も考える
        if (minvalue <= (A + B - K) && maxValue >= (A + B - K)) {
          if ((A + B - maxValue) % 2 == K % 2)
            nextMaxValue = A + B;
          else
            nextMaxValue = A + B - 1;
        } else {
          nextMaxValue = A + B - Math.min(Math.abs((A + B - K) - minvalue),
            Math.abs((A + B - K) - maxValue));
        }
        minvalue = nextMinValue;
        maxValue = nextMaxValue;
      }
      return -1;
    }
  }


  class BinaryFlipWork {
    public int minimalmoves(int A, int B, int K) {
      if (A == 0 || A + B <= K) return -1;
      int array[] = new int[A + B + 1];
      for (int i = 0; i <= A + B; i++) array[i] = -1;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(A);
      array[A] = 0;
      while (!q.isEmpty()) {
        Integer a = q.poll();
        // 0を増やす
        check(q, array, K, a, Math.max(0, K - (A + B - a)));
        // 1を増やす
        check(q, array, K, a, Math.min(a, K));

        // 0をkに近づける
        check(q, array, K, a, Math.min(Math.max((a + 1) / 2, K - (A + B - a)), K));
        check(q, array, K, a, Math.min(Math.max(a / 2, K - (A + B - a)), K));
      }

      return array[0];
    }

    private void check(Queue<Integer> q, int[] array, int k, int nowzero, int usezero) {
      int nextzero = nowzero + k - 2 * usezero;
      if (array[nextzero] == -1) {
        q.add(nextzero);
        array[nextzero] = array[nowzero] + 1;
      }
    }
  }

}
