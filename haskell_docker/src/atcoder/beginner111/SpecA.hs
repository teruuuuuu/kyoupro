import Test.Hspec

swapDigits :: [Char] -> [Char]
swapDigits = map (\a -> if a == '1' then '9' else if a == '9' then '1' else a)

main :: IO ()
main = hspec $ do
  describe "swapDigits" $ do
    it "swaps '1' with '9' and '9' with '1'" $ do
      swapDigits "123456789" `shouldBe` "923456781"
    it "leaves other characters unchanged" $ do
      swapDigits "abc123xyz" `shouldBe` "abc923xyz"
    it "handles empty string" $ do
      swapDigits "" `shouldBe` ""