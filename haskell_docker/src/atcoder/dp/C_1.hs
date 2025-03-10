import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Control.Monad (forM_)
import Control.Monad.State
import Data.Vector.Unboxed ((!))

get_int :: Int -> IO (U.Vector Int)
get_int n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

sol :: Int -> StateT (Int, Int, Int) IO Int
sol n = do
    forM_ [0..n-1] $ \_ -> do
        (cost_a, cost_b, cost_c) <- get
        [a,b,c] <- liftIO $ get_int 3 >>= \x -> pure [x!0,x!1,x!2]
        put (a + max cost_b cost_c, b + max cost_a cost_c, c + max cost_a cost_b)
    (cost_a, cost_b, cost_c) <- get
    return $ maximum [cost_a, cost_b, cost_c]

main :: IO ()
main = do
    [n] <- get_int 1 >>= \x -> pure [x!0]
    result <- evalStateT (sol n) (0, 0, 0)
    print result