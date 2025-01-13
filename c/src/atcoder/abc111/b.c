#include <stdio.h>
#include <string.h>

int solve(int input) {
    return input % 111 == 0 ? input : (input / 111) * 111 + 111;
}


int main() {
    int input;
    scanf("%d", &input);
    printf("%d\n", solve(input));

    return 0;
}
