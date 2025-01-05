import Test.Hspec


nextMultipleOf111 :: Int -> Int
nextMultipleOf111 n
  | n `mod` 111 == 0 = n
  | otherwise        = ((n `div` 111) + 1) * 111

main :: IO ()
main = hspec $ do
  describe "nextMultipleOf111" $ do
    it "returns the same number if it is a multiple of 111" $ do
      nextMultipleOf111 111 `shouldBe` 111
      nextMultipleOf111 222 `shouldBe` 222
      nextMultipleOf111 333 `shouldBe` 333

    it "returns the next multiple of 111 if the number is not a multiple of 111" $ do
      nextMultipleOf111 112 `shouldBe` 222
      nextMultipleOf111 223 `shouldBe` 333
      nextMultipleOf111 334 `shouldBe` 444