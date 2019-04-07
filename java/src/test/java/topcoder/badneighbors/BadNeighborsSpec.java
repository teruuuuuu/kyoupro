package topcoder.badneighbors;

import org.junit.Test;

public class BadNeighborsSpec {

  @Test
  public void test1() {
    int[] neighbors = {10, 3, 2, 5, 7, 8};
    BadNeighbors bn = new BadNeighbors();
    int answer = 19;
    int result = bn.maxDonations(neighbors);
    assert (answer == result);
  }

  @Test
  public void test2() {
    int[] neighbors = {11, 15};
    BadNeighbors bn = new BadNeighbors();
    int answer = 15;
    int result = bn.maxDonations(neighbors);
    assert (answer == result);
  }

  @Test
  public void test3() {
    int[] neighbors = {7, 7, 7, 7, 7, 7, 7};
    BadNeighbors bn = new BadNeighbors();
    int answer = 21;
    int result = bn.maxDonations(neighbors);
    assert (answer == result);
  }

  @Test
  public void test4() {
    int[] neighbors = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
    BadNeighbors bn = new BadNeighbors();
    int answer = 16;
    int result = bn.maxDonations(neighbors);
    assert (answer == result);
  }

  @Test
  public void test5() {
    int[] neighbors =
      {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
        6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
        52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
    BadNeighbors bn = new BadNeighbors();
    int answer = 2926;
    int result = bn.maxDonations(neighbors);
    assert (answer == result);
  }
}
