module Main where

import Data.List (elemIndex)

inputStage :: [Char] -> (Int, Int)
inputStage s = 
  case elemIndex '-' s of
    Just i -> (read $ take i s, read $ drop (i+1) s)
    Nothing -> (0, 0)

nextStage :: (Int, Int) -> (Int, Int)
nextStage (a, b) = if b == 8 then (a + 1, 1) else (a, b + 1)

main :: IO ()
main = do
  n <- getLine
  let (a, b) = inputStage n
  let (c, d) = nextStage (a, b)
  putStrLn $ show c ++ "-" ++ show d