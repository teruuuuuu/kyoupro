#include <iostream>
#include <vector>
#include <unordered_map>

template <class ForwardIterator, class Compare>
ForwardIterator max_element(ForwardIterator first, ForwardIterator last, Compare comp)
{
  if (first == last)
    return first;

  ForwardIterator result = first++;
  for (; first != last; ++first) {
    if (comp(*result, *first)) {
      result = first;
    }
  }
  return result;
}

// 数値毎のカウントを行う関数
std::unordered_map<int, int> count_numbers(const std::vector<int>& numbers) {
    std::unordered_map<int, int> counts;
    for (int num : numbers) {
        counts[num]++;
    }
    return counts;
}

int get_max_value(const std::unordered_map<int, int>& map) {
    if (map.empty()) {
        return 0;
    }

    // std::max_elementを使用して最大値を求める
    auto max = max_element(map.begin(), map.end(),
        [](const std::pair<int, int>& a, const std::pair<int, int>& b) {
            return a.second < b.second;
        });

    return max->second;
}

// 偶数番目と奇数番目の数値を同じにするための変更回数の最小値を求める関数
int min_changes_to_unify(const std::vector<int>& numbers1, const std::vector<int>& numbers2) {
    std::size_t numbers1_size = numbers1.size();
    std::size_t numbers2_size = numbers2.size();

    std::unordered_map<int, int> count_numbers1 = count_numbers(numbers1);
    std::unordered_map<int, int> count_numbers2 = count_numbers(numbers2);
    
    int max_count1 = get_max_value(count_numbers1);
    int max_count2 = get_max_value(count_numbers2);

    return numbers1_size - max_count1 + numbers2_size - max_count2;

}

int main() {
    int n;
    std::cin >> n;
    std::vector<int> number1(n/2);
    std::vector<int> number2(n/2);

    for (int i = 0; i < n; ++i) {
        if (i % 2 == 0) {
            std::cin >> number1[i];
        } else {
            std::cin >> number2[i];
        }
    }
    std::cout << min_changes_to_unify(number1, number2) << std::endl;
    return 0;

}
