module Main where

nextMultipleOf111 :: Int -> Int
nextMultipleOf111 n
  | n `mod` 111 == 0 = n
  | otherwise        = ((n `div` 111) + 1) * 111

main :: IO ()
main = do
  n <- readLn :: IO Int
  print $ nextMultipleOf111 n
