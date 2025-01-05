#include <iostream>
#include <string>

std::string swapDigits(int n) {
    std::string str = std::to_string(n);
    for (char &ch : str) {
        if (ch == '1') {
            ch = '9';
        } else if (ch == '9') {
            ch = '1';
        }
    }
    return str;
}

int main() {
    int n;
    std::cin >> n;
    std::cout << swapDigits(n) << std::endl;
    return 0;
}
