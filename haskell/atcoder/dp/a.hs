-- solve :: [Int] -> Int
-- solve x = case x of
--   [] -> 0
--   [a] -> 0
--   [a, b] -> abs (a - b)
--   a : b : c : d -> solve_dp (b : c : d) (abs (a - b)) (abs (a - c))

-- solve_dp :: [Int] -> Int -> Int -> Int
-- solve_dp x dp0 dp1 = case x of
--   [a, b] -> min (dp0 + abs (a - b)) dp1
--   [a, b, c] -> solve_dp [b, c] (min (dp0 + abs (a - b)) dp1) (dp0 + abs (a - c))
--   a : b : c : d -> solve_dp (b : c : d) ndp0 ndp1
--     where
--       ndp0 = min dp1 $ dp0 + abs (a - b)
--       ndp1 = dp0 + abs (a - c)

-- main = do
--   _ <- (read :: String -> Int) . head . words <$> getLine
--   h <- map (read :: String -> Int) . words <$> getLine
--   print $ solve h


import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Data.Vector.Unboxed ((!))

main = sub =<< get 1

sub u = sol (u!0) <$> get (u!0) >>= print

get n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol n v = dp!(n-1)
  where
  dp = U.constructN n f
  f u
    | i==0  = 0
    | i>0   = U.minimum . U.map (\(d,h) -> d+abs (h-v!i)) . U.drop (i-2) $ U.zip u v
    where
    i = U.length u
