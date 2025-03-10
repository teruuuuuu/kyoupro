import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import qualified Data.Vector.Unboxed.Mutable as M
import Control.Monad (forM_, when)
import Control.Monad.ST (runST)
import Data.Vector.Unboxed ((!))

-- 文字列からベクターとして読み込み
get :: Int -> IO (U.Vector Int)
get n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

-- 動的計画法を使用して最小コストを計算する関数
sol :: U.Vector Int -> Int
sol h = runST $ do
    let n = U.length h
    dp <- M.replicate n 0
    M.write dp 0 0
    when (n > 1) $ M.write dp 1 (abs (h U.! 1 - h U.! 0))
    forM_ [2..n-1] $ \i -> do
        cost1 <- (+ abs (h U.! i - h U.! (i - 1))) <$> M.read dp (i - 1)
        cost2 <- (+ abs (h U.! i - h U.! (i - 2))) <$> M.read dp (i - 2)
        M.write dp i (min cost1 cost2)
    M.read dp (n - 1)

-- 7 ms	14248 KB
-- 一番高性能
main :: IO ()
main = do
    n <- get 1 >>= \n -> pure (n!0)
    h <- get n
    print $ sol h
    