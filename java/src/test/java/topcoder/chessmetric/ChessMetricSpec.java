package topcoder.chessmetric;

import org.junit.Test;

public class ChessMetricSpec {

  @Test
  public void test1() {
    ChessMetric cm = new ChessMetric();
    int size = 3;
    int[] start = {1, 0};
    int[] end = {0, 1};
    int numMoves = 1;
    long ans = 1;
    long result = cm.howMany(size, start, end, numMoves);
    assert(ans == result);
  }

  @Test
  public void test2() {
    ChessMetric cm = new ChessMetric();
    int size = 3;
    int[] start = {0, 0};
    int[] end = {1, 2};
    int numMoves = 1;
    long ans = 1;
    long result = cm.howMany(size, start, end, numMoves);
    assert(ans == result);
  }

  @Test
  public void test3() {
    ChessMetric cm = new ChessMetric();
    int size = 3;
    int[] start = {0, 0};
    int[] end = {2, 2};
    int numMoves = 1;
    long ans = 0;
    long result = cm.howMany(size, start, end, numMoves);
    assert(ans == result);
  }

  @Test
  public void test4() {
    ChessMetric cm = new ChessMetric();
    int size = 3;
    int[] start = {0, 0};
    int[] end = {0, 0};
    int numMoves = 2;
    long ans = 5;
    long result = cm.howMany(size, start, end, numMoves);
    assert(ans == result);
  }

  @Test
  public void test5() {
    ChessMetric cm = new ChessMetric();
    int size = 100;
    int[] start = {0, 0};
    int[] end = {0, 99};
    int numMoves = 50;
    long ans = 243097320072600L;
    long result = cm.howMany(size, start, end, numMoves);
    assert(ans == result);
  }

}
