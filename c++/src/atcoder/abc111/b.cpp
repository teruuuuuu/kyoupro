#include <cstdint> 
#include <iostream>

std::int32_t multiple_adgustment_n(int n, int x) {
    int32_t result = (x / n) * n;
    if (result == x) {
        return result;
    } else {
        return result + n;
    }
}

int main() {
    auto multiple_adgustment_111 = [](int x) { 
        return multiple_adgustment_n(111, x); 
    };
    int n;
    std::cin >> n;
    std::cout << multiple_adgustment_111(n) << std::endl;
    return 0;
}
