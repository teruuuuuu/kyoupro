import Control.Monad
import Data.List as L

data ABCD = Input
  { a :: Int,
    b :: Int,
    c :: Int,
    d :: Int
  }
  deriving (Show)

toAbcd :: [Int] -> ABCD
toAbcd input = case input of
  a : b : c : d : _ -> Input a b c d

patterns :: Int -> Int -> Int -> [[Int]]
patterns 0 _ _ = [[]]
patterns rest start end = concat $ map (\a -> map (\b -> a : b) $ patterns (rest -1) a end) [start .. end]

score :: [ABCD] -> [Int] -> Int
score inputs pattern =
  foldl
    ( \acc cur ->
        if (pattern !! ((b cur) - 1)) - (pattern !! ((a cur) - 1)) == (c cur)
          then acc + d cur
          else acc
    )
    0
    inputs

main = do
  (n : m : q : _) <- L.map read . words <$> getLine :: IO [Int]
  inputs <- map toAbcd <$> forM [1 .. q] (\_ -> L.map read . words <$> getLine :: IO [Int])
  print $ maximum $ map (\a -> score inputs a) $ patterns n 1 m
