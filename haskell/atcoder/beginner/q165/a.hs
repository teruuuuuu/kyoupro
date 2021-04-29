import Data.List as L

main = do
  (k : _) <- L.map read . words <$> getLine :: IO [Int]
  (a : b : _) <- L.map read . words <$> getLine :: IO [Int]
  putStrLn $ if (k - a `mod` k) `mod` k <= b - a then "OK" else "NG"

-- putStrLn $ (k-(a%k))%k <= b - a then "OK" else "NG"
-- putStrLn $ k
-- putStrLn $ map (\a -> if a=='1' then '9' else if a=='9' then '1' else a) n
