module AtCoder.Beginner.Q085.A where

  import Control.Monad
  import Data.List

  answer :: IO ()
  answer = do
   n <- readLn
   ds <- replicateM n readLn
   print $ length $ group $ sort (ds :: [Integer])
