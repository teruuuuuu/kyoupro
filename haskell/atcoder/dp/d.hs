import Control.Monad
import qualified Data.ByteString.Char8 as C
import Data.List
import qualified Data.Vector.Unboxed as U

main = get >>= \(n,k) -> sol (k+1) <$> replicateM n get >>= print

get = (\[x,y] -> (x,y)) . unfoldr (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol k wv = U.last $ foldl' f (U.replicate k 0) wv
  where
  f u (w,v) = U.zipWith max u (U.replicate w 0 U.++ U.map (+v) u)
