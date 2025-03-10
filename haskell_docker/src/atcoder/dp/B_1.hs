import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import qualified Data.Vector.Unboxed.Mutable as M
import Control.Monad (forM_)
import Control.Monad.ST (runST)
import Data.Vector.Unboxed ((!))
-- import Debug.Trace

-- 文字列からベクターとして読み込み
get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol :: Int -> U.Vector Int -> Int
sol k h = runST $ do
  let n = U.length h
  dp <- M.replicate n (maxBound :: Int)
  M.write dp 0 0
  forM_ [0..n-1] $ \i -> do
    let m = max (min k (n-i-1)) 0
    -- traceM $ "i: " ++ show i ++ ", m: " ++ show m
    forM_ [1..m] $ \j -> do
      let ij = i + j
      cost_a <- M.read dp ij
      cost_b <- (+ abs ((h U.! ij) - (h U.! i))) <$> M.read dp i
      -- traceM $ "i: " ++ show i ++ ", j: " ++ show j ++ ", cost_a: " ++ show cost_a ++ ", cost_b: " ++ show cost_b
      M.write dp ij (min cost_a cost_b)
  M.read dp (n-1)

main :: IO ()
main = do
    [n,k] <- get_int 2 >>= \x -> pure [x!0,x!1]
    h <- get_int n
    print $ sol k h
