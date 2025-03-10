import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Control.Monad (forM_)
import Control.Monad.State
import Data.Vector.Unboxed ((!))

get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol :: Int -> Int -> StateT (U.Vector Int) IO Int
sol n w = do
    forM_ [0..n-1] $ \_ -> do
        h <- get
        [wi,vi] <- liftIO $ get_int 2 >>= \x -> pure [x!0,x!1]
        let h' = U.accum (\x y -> max x y) h [(i, h U.! (i - wi) + vi) | i <- [wi..w], i - wi >= 0]
        put h'
    h <- get
    return $ h U.! w

main :: IO ()
main = do
    [n,w] <- get_int 2 >>= \x -> pure [x!0,x!1]
    result <- evalStateT (sol n w) $ U.replicate (w+1) 0
    print result