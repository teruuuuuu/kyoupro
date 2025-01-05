#include <gtest/gtest.h>
#include <iostream>
#include "a.h" 

TEST(SwapDigitsTest, HandlesSingleDigit) {
    EXPECT_EQ(swapDigits(111), "999");
    EXPECT_EQ(swapDigits(999), "111");
    EXPECT_EQ(swapDigits(191), "919");
}

TEST(SwapDigitsTest, HandlesMixedDigits) {
    EXPECT_EQ(swapDigits(119), "991");
    EXPECT_EQ(swapDigits(911), "199");
    EXPECT_EQ(swapDigits(191), "919");
    EXPECT_EQ(swapDigits(919), "191");
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}