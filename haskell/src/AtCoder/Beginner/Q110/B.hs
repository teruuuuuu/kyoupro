module AtCoder.Beginner.Q110.B where
import Control.Monad
import Control.Applicative
import Data.List
import qualified Data.Map.Strict as M
import Control.Monad (mfilter)

toInt :: (String -> Int)
toInt x = read x ::Int

getInts = do
  x <- getLine
  let y = (map$toInt)$words x
  return y

getStr = do
  x <- getLine
  let y = words x
  return y

arrayToInt :: [Int] -> Int
arrayToInt a = foldl (+) 0 $ map (\x -> snd x * 10^(fst x)) $ zip [0..((length a)-1)] a

answer :: IO ()
answer = do
  [xn, yn, x, y] <- getInts
  xs <- getInts
  ys <- getInts
  putStrLn $ if (maximum $ xs ++ [x]) >= (minimum $ ys ++ [y]) then "War" else "No War"
