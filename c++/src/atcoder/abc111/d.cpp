#include <algorithm> // std::transform
#include <cmath>
#include <iterator>
#include <sstream>
#include <iostream>
#include <set>
#include <tuple>
#include <vector>

const char U = 'U';
const char D = 'D';
const char L = 'L';
const char R = 'R';


std::set<int> vec_to_mod_set(const std::vector<std::tuple<int, int>>& numbers) {
    std::set<int> mods_set;
    int mod = 0;
    for (const auto& tuple: numbers) {
        mod = std::abs(std::get<0>(tuple) + std::get<1>(tuple)) % 2;
        mods_set.insert(mod);
    }
    return mods_set;
}


void solve_robot_arm(const std::vector<std::tuple<int, int>>& numbers) {
    std::set<int> mods_set = vec_to_mod_set(numbers);    
    if (mods_set.size() != 1) {
        std::cout << "-1" << std::endl;
        return;
    }
    bool is_even_mod = mods_set.contains(1);
    if (is_even_mod) {
        std::cout << 31 << std::endl;
    } else {
        std::cout << 32 << std::endl;
    }

    if (!is_even_mod) {
        std::cout << "1 ";
    }
    for(int i = 0; i < 31; i++) {
        if (i != 0) {
            std::cout << " ";
        }
        std::cout << (1<<i);
    }
    std::cout << std::endl;


    int x,y;
    int uj;
    int uj_binary;
    int vj;
    int vj_binary ;
    bool is_uj_on;
    bool is_vj_on;
    int arm_length = 2147483647;

    for (size_t i = 0; i < numbers.size(); ++i) {
        int x = std::get<0>(numbers[i]);
        int y = std::get<1>(numbers[i]);

        if (!is_even_mod) {
            x -= 1;
            std::cout << R;
        }

        uj = x + y;
        uj_binary = (uj + arm_length) / 2;
        vj = x - y;
        vj_binary = (vj + arm_length) / 2;
        for (int i=0; i < 31; i++) {
            is_uj_on = uj_binary & (1 << i);
            is_vj_on = vj_binary & (1 << i);
            if (is_uj_on && is_vj_on) {
                std::cout << R;
            } else if (is_uj_on && !is_vj_on) {
                std::cout << U;
            } else if (!is_uj_on && is_vj_on) {
                std::cout << D;
            } else {
                std::cout << L;
            }
        }
        std::cout << std::endl;
    }
    return;
}

int main() {
    int n;
    std::cin >> n;

    std::vector<std::tuple<int, int>> numbers(n);
    for (int i = 0; i< n; i++) {
        int x, y;
        std::cin >> x >> y;
        numbers[i] = std::make_tuple(x, y);
    }

    solve_robot_arm(numbers);
    return 0;
}
