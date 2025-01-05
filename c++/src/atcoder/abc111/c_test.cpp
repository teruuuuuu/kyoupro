#include <gtest/gtest.h>
#include <iostream>
#include "c.h" 

TEST(MinChangesToUnifyTest, case1) {
    std::vector<int> number1 = {3, 3};
    std::vector<int> number2 = {1, 2};
    EXPECT_EQ(min_changes_to_unify(number1, number2), 1);

}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}