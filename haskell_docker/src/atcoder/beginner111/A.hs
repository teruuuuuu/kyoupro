module Main where

swapDigits :: [Char] -> [Char]
swapDigits = map (\a -> if a == '1' then '9' else if a == '9' then '1' else a)

main :: IO ()
main = do
  n <- getLine
  putStrLn $ swapDigits n