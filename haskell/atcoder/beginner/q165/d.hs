import Data.List as L

main = do
  (a : b : n : _) <- L.map read . words <$> getLine :: IO [Int]
  print $ a * min (b -1) n `div` b
