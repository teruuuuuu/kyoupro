import Control.Monad
import qualified Data.ByteString.Char8 as C
import Data.List
import qualified Data.Vector.Unboxed as U

main :: IO ()
main = get_int_pair >>= \(n,k) -> sol n k <$> replicateM n get_int_pair >>= print

get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

get_int_pair :: IO (Int, Int)
get_int_pair = get_int 2 >>= \x -> pure (x U.! 0, x U.! 1)

sol :: Int -> Int -> [(Int, Int)] -> Int
sol n k wv = U.length . U.takeWhile (<=k) $ foldl' f (U.replicate (n*1000) (k+1)) wv

f :: U.Vector Int -> (Int, Int) -> U.Vector Int
f u (w,v) = U.zipWith min u (U.replicate v w U.++ U.map (+w) u)
