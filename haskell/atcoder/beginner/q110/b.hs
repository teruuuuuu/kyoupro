import Control.Applicative
import Control.Monad
import Control.Monad (mfilter)
import Data.List
import qualified Data.Map.Strict as M

toInt :: (String -> Int)
toInt x = read x :: Int

getInts = do
  x <- getLine
  let y = (map $toInt) $words x
  return y

getStr = do
  x <- getLine
  let y = words x
  return y

arrayToInt :: [Int] -> Int
arrayToInt a = foldl (+) 0 $ map (\x -> snd x * 10 ^ (fst x)) $ zip [0 .. ((length a) -1)] a

main :: IO ()
main = do
  [xn, yn, x, y] <- getInts
  xs <- getInts
  ys <- getInts
  putStrLn $ if (maximum $ xs ++ [x]) >= (minimum $ ys ++ [y]) then "War" else "No War"
