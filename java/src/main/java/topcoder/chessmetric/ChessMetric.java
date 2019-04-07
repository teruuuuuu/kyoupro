package topcoder.chessmetric;

import java.util.ArrayList;
import java.util.List;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
 */
public class ChessMetric {
  public long howMany(int size, int[] start, int[] end,
                      int numMoves) {
//    ChessMetric1 cm = new ChessMetric1();
//    return cm.howMany(size, start, end, numMoves);
    ChessMetricWork cm = new ChessMetricWork();
    return cm.howMany(size, start, end, numMoves);
  }

  class ChessMetricWork {
    int[][] moves = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0},
      {-1, 1}, {0, 1}, {1, 1}, {-1, -2}, {1, -2}, {-2, -1}, {2, -1},
      {-2, 1}, {2, 1}, {-1, 2}, {1, 2}};

    public long howMany(int size, int[] start, int[] end,
                       int numMoves) {
      long[][][] dp = new long[size][size][numMoves+1];
      dp[start[0]][start[1]][0] = 1;
      for(int i = 0; i < numMoves; i++ ) {
        for(int x = 0; x < size; x++ ) {
          for(int y = 0; y < size; y++ ){
            if(dp[x][y][i] == 0) continue;
            for(int[] n: moves){
              int nx = x+n[0];
              int ny = y+n[1];
              if(nx<0 || nx>=size || ny <0 || ny >= size) continue;
              dp[nx][ny][i+1] += dp[x][y][i];
            }
          }
        }
      }
      return dp[end[0]][end[1]][numMoves];
    }
  }

  class ChessMetric1 {
    long[][][] ways = new long[100][100][100];
    int[] dx = new int[]{1, 1, 1, 0, -1, -1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};
    int[] dy = new int[]{1, 0, -1, -1, -1, 0, 1, 1, -1, -2, -2, -1, 1, 2, 2, 1};

    public long howMany(int size, int[] start, int[] end, int numMoves) {
      int x, y, i, j;
      int sx = start[0], sy = start[1], ex = end[0], ey = end[1];

      ways[sy][sx][0] = 1;
      for (i = 1; i <= numMoves; i++) {
        for (x = 0; x < size; x++) {
          for (y = 0; y < size; y++) {
            for (j = 0; j < 16; j++) {
              int nx = x + dx[j];
              int ny = y + dy[j];
              if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
              ways[ny][nx][i] += ways[y][x][i - 1];
            }
          }
        }
      }
      return ways[ey][ex][numMoves];
    }
  }
}
