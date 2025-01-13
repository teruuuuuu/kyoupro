#include <stdio.h>
#include <string.h>

char* swap_1_and_9(char *str) {
    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '1') {
            str[i] = '9';
        } else if (str[i] == '9') {
            str[i] = '1';
        }
    }
    return str;
}

int main() {
    char input[10];
    fgets(input, sizeof(input), stdin); 
    size_t len = strlen(input);
    if (len > 0 && input[len-1] == '\n') {
        input[len-1] = '\0';
    }

    for (int i = 0; i < len; i++) {
        if (input[i] < '0' || input[i] > '9') {
            return 1;
        }
    }
    printf("%s\n", swap_1_and_9(input));

    return 0;
}