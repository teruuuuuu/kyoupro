import Control.Monad
import Data.Bool
import qualified Data.ByteString.Char8 as C
import qualified Data.Vector as V
import qualified Data.Vector.Unboxed as U
import Data.Vector.Generic ((!))

main = sol <$> get >>= putStrLn

-- get = C.words <$> C.getContents
get = replicateM 2 $ C.getLine

sol [s,t] = lcs s t

lcs s t = go (V.length tbl-1) (U.length (tbl!0)-1) []
  where
  tbl = dp s t
  go i j as
    | i<0 || j<0                  = as
    | C.index s i==C.index t j    = go (i-1) (j-1) (C.index s i:as)
    | j>0 && tbl!i!j==tbl!i!(j-1) = go i (j-1) as
    | i>0 && tbl!i!j==tbl!(i-1)!j = go (i-1) j as
    | otherwise                   = as

dp :: C.ByteString -> C.ByteString -> V.Vector (U.Vector Int)
dp s t = V.postscanl' (upd t) (U.replicate (C.length t) 0) $ V.generate (C.length s) (C.index s)
upd t u c = U.unfoldrN (C.length t) (hlp t u c) (0,0)
hlp t u c (n,i) = Just (n',(n',i+1))
  where
  n' = if c==C.index t i
    then 1+bool (u!(i-1)) 0 (i==0)
    else max n (u!i)
