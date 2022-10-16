package topcoder.batchsystem;

import org.junit.Test;

import java.util.Arrays;

public class BatchSystemSpec {

  @Test
  public void test() {
    int[] durations = {400, 100, 100, 100};
    String[] users = {"Danny", "Stella", "Stella", "Mac"};

    BatchSystem batchSystem = new BatchSystem();
    int[] result = batchSystem.schedule(durations, users);
    System.out.println(Arrays.toString(result));

    int[] ans = {3, 1, 2, 0};
    assert(Arrays.equals(result, ans));
  }
}
