#include <stdio.h>
int
digits(int num) {
  int ret = 0;
  while (1) {
    num /= 10;
    ret += 1;
    if(num == 0) {
      break;
    }
  }
  return ret;
}
int
base_num(int digits) {
  int ret = 1;
  while(--digits) {
    ret = ret*10+1;
  }
  return ret;
}

int
main(void)
{
  int input;
  scanf("%d", &input);
  int ketasu = digits(input);
  int baseNum = base_num(ketasu);
  int ans = baseNum;
  while(input > ans) {
    ans += baseNum;
  }
  printf("%d\n", ans);
  return 0;
}
