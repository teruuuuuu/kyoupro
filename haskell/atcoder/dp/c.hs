import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Data.Vector.Unboxed ((!))

main = do
  n <- (read :: String -> Int) <$> getLine
  mapM (\_ -> get 3) [1..n] >>= (\abc -> print $ solve abc [0, 0, 0])

get n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

solve :: [U.Vector Int] -> [Int] -> Int
solve [] dp = maximum dp
solve (h:t) (a:b:c:[]) = solve t [h!0 + max b c, h!1 + max a c, h!2 + max a b]


-- import qualified Data.ByteString.Char8 as C
-- import Data.List
-- import Data.Vector.Unboxed ((!),unfoldrN)

-- main = readLn >>= \n -> sol n <$> get (3*n) >>= print

-- get t = unfoldrN t (C.readInt . C.dropWhile (<'+')) <$> C.getContents

-- sol n v = maximum $ foldl' f [0,0,0] [0..n-1]
--   where
--   f [d0,d1,d2] i = [v!(3*i)+max d1 d2,v!(3*i+1)+max d2 d0,v!(3*i+2)+max d0 d1]
