cost :: Int -> Int -> Int -> Int -> Int -> Int
cost a b x y z = min (a + abs (z - x)) (b + abs (z - y))

solve :: [Int] -> Int
solve [] = 0
solve [x] = 0
solve [x,y] = abs (y - x)
solve (x:y:xs) = sol 0  (abs (y - x)) (x:y:xs)
    where
        sol :: Int -> Int -> [Int] -> Int
        sol a b [x,y,z] = cost a b x y z
        sol a b (x:y:z:xs) = sol b (cost a b x y z) (y:z:xs)

-- 131 ms	33688 KB
main :: IO ()
main = do
    _ <- readLn :: IO Int
    h <- map (read :: String -> Int) . words <$> getLine
    print $ solve h
    