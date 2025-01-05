#include <gtest/gtest.h>
#include <iostream>
#include "b.h" 

TEST(MultipleAdgustmentTest, case1) {
    auto multiple_adgustment_111 = [](int x) { 
        return multiple_adgustment_n(111, x); 
    };
    EXPECT_EQ(multiple_adgustment_111(111), 111);
    EXPECT_EQ(multiple_adgustment_111(112), 222);
    EXPECT_EQ(multiple_adgustment_111(221), 222);
    EXPECT_EQ(multiple_adgustment_111(223), 333);
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}