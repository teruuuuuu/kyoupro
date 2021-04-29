main = do
  n <- getLine :: IO [Char]
  putStrLn $ map (\a -> if a == '1' then '9' else if a == '9' then '1' else a) n
