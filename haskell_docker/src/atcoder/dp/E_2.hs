import Control.Monad
import qualified Data.ByteString.Char8 as C
import Data.List
import qualified Data.Vector.Unboxed as U
-- import Debug.Trace

get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

get_int_pair :: IO (Int, Int)
get_int_pair = get_int 2 >>= \x -> pure (x U.! 0, x U.! 1)

next_cost :: U.Vector Int -> (Int, Int) -> U.Vector Int
-- next_cost cost (w,v) = trace ("w: " ++ show w ++ ", v:" ++ show v ++ ", cost:" ++ show cost) $  U.zipWith min cost (U.replicate v w U.++ U.map (+w) cost)
next_cost cost (w,v) = U.zipWith min cost (U.replicate v w U.++ U.map (+w) cost)

main :: IO ()
main = do
    (n,w) <- get_int_pair
    wvs <- replicateM n get_int_pair
    let cost = U.replicate (n*1000) (w+1)
    let result = U.length . U.takeWhile (<=w) $ foldl' next_cost cost wvs
    print result