#include <stdio.h>
#include <stdlib.h>

struct crazy_bot {
    int **grid;
    double prob[4];
    int direction[4][2];
};

struct crazy_bot
*init(double east, double west, double south, double north)
{
  struct crazy_bot *cb;
  cb->grid = malloc(sizeof(int *) * 100);
  for(int i = 0; i < 100; i++){
    cb->grid[i] = malloc(sizeof(int) * 100);
    for(int j = 0; j < 100; j++){
      cb->grid[i][j] = i * j;
    }
  }
  // cb->prob = malloc(sizeof(double) * 4);
  cb->prob[0] = east/100.0;
  cb->prob[1] = west/100.0;
  cb->prob[2] = south/100.0;
  cb->prob[3] = north/100.0;
  cb->direction[0][0] = 1;
  cb->direction[0][1] = 0;
  cb->direction[1][0] = -1;
  cb->direction[1][1] = 0;
  cb->direction[2][0] = 0;
  cb->direction[2][1] = 1;
  cb->direction[3][0] = 0;
  cb->direction[3][1] = -1;
  return cb;
}

double
solv(struct crazy_bot *cb, int n, int x, int y)
{
  if (cb->grid[x][y] == 1) return 0;
  if (n == 0) return 1;

  double ret = 0;
  cb->grid[x][y] = 1;
  for (int i=0; i < 4; i++ ){
    ret += solv(cb, n - 1, x+cb->direction[i][0], y+cb->direction[i][1]) * cb->prob[i];
  }
  cb->grid[x][y] = 0;
  return ret;
}
int
main(void)
{
  int N, east, west, south, north = 0;
  scanf("%d", &N);
  scanf("%d", &east);
  scanf("%d", &west);
  scanf("%d", &south);
  scanf("%d", &north);
  struct crazy_bot *cb = init(east, west, south, north);
  printf("%f\n", solv(cb, N, 50, 50));
  return 0;
}

