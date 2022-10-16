package topcoder;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgorithm {

  boolean isConnect(int[][] edge, int from, int to, int v){
    boolean[] dp = new boolean[v];
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(from);
    dp[from] = true;

    while(!q.isEmpty()) {
      int now = q.poll();
      for(int i = 0; i < edge[now].length; i++ ){
        int next = edge[now][i];
        if(dp[next]) continue;
        if(next == to) return true;
        dp[next] = true;
        q.add(next);
      }
    }
    return false;
  }
}
