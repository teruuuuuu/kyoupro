module AtCoder.Beginner.Q086.A where

answer = do
  [a,b] <- map read . words <$> getLine
  if (a * b) `mod` 2 == 0 then putStrLn "Even" else putStrLn "Odd"
