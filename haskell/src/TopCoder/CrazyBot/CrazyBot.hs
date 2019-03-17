module TopCoder.CrazyBot.CrazyBot where
import Data.List as L

type Position = (Int, Int)
type Direction = (Position, Float)

dirs :: Int -> Int -> Float -> Direction
dirs x y p = ((x, y), p/100)

solve :: [Position] -> [Direction] -> Int -> Position -> Float
solve hist dirs n p = do
  case p `elem` hist of
    True -> 0.0
    False ->
      if n == 0 then 1
      else L.foldl' (\acc ((nx, ny), prob) -> acc + (solve (hist ++ [((fst p), (snd p))]) dirs (n-1) ((fst p)+nx, (snd p)+ny)) * prob) 0 dirs

answer = do
  n<-L.map read . words<$>getLine::IO[Int]
  east<-L.map read . words<$>getLine::IO[Float]
  west<-L.map read . words<$>getLine::IO[Float]
  south<-L.map read . words<$>getLine::IO[Float]
  north<-L.map read . words<$>getLine::IO[Float]
  let dir = [dirs 1 0 (head east), dirs (-1) 0 (head west), dirs 0 1 (head south), dirs 0 (-1) (head north)]
  print $ solve [] dir (head n) (50, 50)
