package topcoder.batchsystem;

import java.util.HashMap;
import java.util.Map;


/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=10808&rd=14234
 */
public class BatchSystem {
  static void main(String[] args) {

  }

  public int[] schedule(int duration[], String users[]) {
    int N = duration.length;

    Map<String, Long> jobTime = new HashMap<String, Long>();
    for (int n = 0; n < N; n++) jobTime.put(users[n], 0L);
    for (int n = 0; n < N; n++) {
      jobTime.put(users[n], jobTime.get(users[n]) + duration[n]);
    }

    boolean[] done = new boolean[N];
    int[] ans = new int[N];
    int ansCount = 0;
    while (ansCount < N) {
      String next = "";
      for (int n = 0; n < N; n++) {
        if(!done[n] &&
                (next.equals("") || jobTime.get(users[n]) < jobTime.get(next))) {
          next = users[n];
        }
      }

      for (int n = 0; n < N; n++ ) {
        if(users[n].equals(next)) {
          done[n] = true;
          ans[ansCount++] = n;
        }
      }
    }

    return ans;
  }
}
