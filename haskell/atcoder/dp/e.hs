import Control.Monad
import qualified Data.ByteString.Char8 as C
import Data.List
import qualified Data.Vector.Unboxed as U

main = get >>= \(n,k) -> sol n k <$> replicateM n get >>= print

get = (\[x,y] -> (x,y)) . unfoldr (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol n k wv = U.length . U.takeWhile (<=k) $ foldl' f (U.replicate (n*10^3) (10^9+1)) wv

f u (w,v) = U.zipWith min u (U.replicate v w U.++ U.map (+w) u)
