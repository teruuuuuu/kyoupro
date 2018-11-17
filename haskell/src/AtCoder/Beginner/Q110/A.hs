module AtCoder.Beginner.Q110.A where
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

q1 :: ([Int], [Int]) -> Int
q1 x = (arrayToInt . snd) x + (head . fst) x

answer :: IO ()
answer = do
  x <- getInts
  print $ q1 $ splitAt 1 $ sort x
