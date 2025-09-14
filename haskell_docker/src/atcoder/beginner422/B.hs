module Main where

import Control.Monad (replicateM)
import qualified Data.Vector as V
import qualified Data.ByteString.Char8 as C
import qualified Data.Vector.Unboxed as U
import Data.Vector.Unboxed ((!))
-- import Debug.Trace

getInt :: Int -> IO (U.Vector Int)
getInt n = U.unfoldrN n (C.readInt . C.dropWhile (<'+')) <$> C.getLine

getMatrix :: Int -> IO (V.Vector (U.Vector Char))
getMatrix h = do
  rowsList <- replicateM h (U.fromList . C.unpack <$> C.getLine)
  pure $ V.fromList rowsList

refMatrix :: V.Vector (U.Vector Char) -> (Int, Int) -> Char
refMatrix matrix (y, x) = (matrix V.! y) U.! x

isBlack :: V.Vector (U.Vector Char) -> (Int, Int) -> Bool
isBlack matrix (y, x) = 
  if x < 0 || y < 0 || y >= V.length matrix || x >= U.length (matrix V.! y)
    then False
    else refMatrix matrix (y, x) == '#'

nextSquares :: (Int, Int) -> [(Int, Int)]
nextSquares (y,x) = [(y-1,x),(y+1,x),(y,x-1),(y,x+1)]

nextBlackSquares :: V.Vector (U.Vector Char) -> (Int, Int) -> [(Int, Int)]
nextBlackSquares matrix (y,x) = filter (isBlack matrix) (nextSquares (y,x))

checkTarget :: V.Vector (U.Vector Char) -> (Int, Int) -> Bool
checkTarget matrix (y,x) = 
  if isBlack matrix (y,x) 
    then 
      let nextBlackLength = length (nextBlackSquares matrix (y,x))
      in nextBlackLength == 2 || nextBlackLength == 4
    else True

searchMatrix :: V.Vector (U.Vector Char) -> (Int, Int) -> Bool
searchMatrix matrix (y,x) = 
  if checkTarget matrix (y,x) then 
    if x + 1 < U.length (matrix V.! y) then searchMatrix matrix (y, x + 1)
    else if y + 1 < V.length matrix then searchMatrix matrix (y + 1, 0)
    else True
  else False

main :: IO ()
main = do
  [h,_] <- getInt 2 >>= \x -> pure [x!0,x!1]
  matrix <- getMatrix h
  putStrLn $ if searchMatrix matrix (0,0) then "Yes" else "No"
