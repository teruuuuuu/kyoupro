import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Data.Vector.Unboxed ((!))

main = sub =<< get 2

sub u = sol (u!0) (u!1) <$> get (u!0) >>= print

get n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol n k v = dp!(n-1)
  where
  dp = U.constructN n f
  f u
    | i == 0    = 0
    | otherwise = U.minimum . U.map (\(d,h) -> d + abs(v U.! i - h)) . U.drop (max 0 (i-k)) $ U.zip u v
    where
      i = U.length u