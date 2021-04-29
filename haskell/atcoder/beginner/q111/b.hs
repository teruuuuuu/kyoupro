import Data.Char as C
import Data.List as L

main = do
  n <- getLine :: IO [Char]
  print $ (\a -> a * 111) $ if (L.foldl' (\a c -> a && (head n) >= c) True (tail n)) then C.digitToInt (head n) else (C.digitToInt (head n) + 1)
