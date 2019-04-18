package topcoder.floorboards;

public class FloorBoards {
  public int layout(String[] room) {
    int i, j, k, len = room[0].length();
    int MAX = 99999;
    int[] dp = new int[1 << len];
    for (i = 0; i < (1 << len); i++) dp[i] = MAX;
    dp[0] = 0;
    for (i = 0; i < room.length; i++) {
      for (j = 0; j < room[0].length(); j++) {
        int[] nextdp = new int[1 << len];
        for (k = 0; k < (1 << len); k++) nextdp[k] = MAX;
        for (k = 0; k < (1 << len); k++) {
          if (dp[k] == MAX) continue;
          int next0 = (k << 1) & ((1 << len) - 1);
          int next1 = next0 + 1;
          if (room[i].charAt(j) == '#') {
            nextdp[next0] = Math.min(nextdp[next0], dp[k]);
          } else {
            if (i != 0 && room[i - 1].charAt(j) != '#' && (k >> (len - 1)) % 2 == 1)
              nextdp[next1] = Math.min(nextdp[next1], dp[k]);
            else
              nextdp[next1] = Math.min(nextdp[next1], dp[k] + 1);
            if(j != 0 && room[i].charAt(j-1) != '#' && k %2 == 0)
              nextdp[next0] = Math.min(nextdp[next0], dp[k]);
            else
              nextdp[next0] = Math.min(nextdp[next0], dp[k] + 1);
          }
        }
        dp = nextdp;
      }
    }
    int res = MAX;
    for(i = 0; i < (1 << len); i++ ) res = Math.min(res, dp[i]);
    return res;
  }
}
