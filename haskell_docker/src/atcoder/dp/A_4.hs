import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Control.Monad (forM_)
import Control.Monad.State
import Data.Vector.Unboxed ((!))

-- 文字列からベクターとして読み込み
get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

cost :: Int -> Int -> Int -> Int -> Int -> Int
cost a b x y z = min (a + abs (z - x)) (b + abs (z - y))

-- 動的計画法を使用して最小コストを計算する関数
sol :: U.Vector Int -> Int
sol h = evalState ( do
    let n = U.length h
    put (0, abs (h U.! 1 - h U.! 0))
    forM_ [0..n-3] $ \i -> do
        (cost_a, cost_b) <- get
        let x = h U.! i
        let y = h U.! (i+1)
        let z = h U.! (i+2)
        put (cost_b, cost cost_a cost_b x y z)
    (_, finalCost) <- get
    return finalCost) (0, 0)

    

-- 6 ms	13848 KB
main :: IO ()
main = do
    n <- get_int 1 >>= \n -> pure (n!0)
    h <- get_int n
    print $ sol h
    