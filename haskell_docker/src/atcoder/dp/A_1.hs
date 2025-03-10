import Data.Array

-- リストから配列への変換
listToArray :: [Int] -> Array Int Int
listToArray xs = listArray (0, length xs - 1) xs

sol :: Array Int Int -> Int
sol h = dp ! (length h - 1)
  where
    dp = array (0, n) [(i, sol' i) | i <- [0..n]]
    sol' 0 = 0
    sol' 1 = abs (h!1 - h!0)
    sol' i = min (dp!(i-1) + abs (h!i - h!(i - 1))) (dp!(i-2) + abs (h!i - h!(i - 2)))
    n = length h - 1

-- 213 ms	90480 KB
main :: IO ()
main = do
    _ <- readLn :: IO Int
    h <- map (read :: String -> Int) . words <$> getLine
    print $ sol (listToArray h)
    