import Data.List as L

next :: Int -> Int
next a = floor $ (realToFrac (a :: Int)) * (1.01 :: Double)

solve :: Int -> Int -> Int -> Int
solve current x count = case current >= x of
  True -> count
  False -> solve (next current) x (count + 1)

main = do
  (x : _) <- L.map read . words <$> getLine :: IO [Int]
  print $ solve 100 x 0
