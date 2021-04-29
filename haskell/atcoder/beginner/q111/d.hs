import Control.Monad
import Data.List as L

bit :: Int -> [Int]
bit n = [2 ^ i | i <- [0 .. n -1]]

odd_even :: [(Int, Int)] -> (Bool, Bool)
odd_even a =
  let (h : t) = (map (\(x, y) -> mod (x + y) 2) a)
   in (and (map (h ==) t), h == 0)

ls_accum :: (b -> (b, c)) -> (b -> Bool) -> b -> [c]
ls_accum f condition state = if condition state then [] else let (next, res) = f state in res : (ls_accum f condition next)

bit_expand :: Int -> [Bool]
bit_expand n = ls_accum (\i -> (div i 2, (mod i 2) == 1)) (0 ==) n

sigma_bit :: Int -> Int -> [Bool]
sigma_bit n m = let bits = bit_expand (div (m + (2 ^ n - 1)) 2) in bits ++ (take (n - (length bits))) (repeat False)

solver :: Int -> (Int, Int) -> [Char]
solver n (x, y) = (map to_char) (zip (sigma_bit n (x + y)) (sigma_bit n (x - y)))
  where
    to_char (b, c) = case (b, c) of
      (True, True) -> 'R'
      (True, False) -> 'U'
      (False, True) -> 'D'
      (False, False) -> 'L'

adj_solver :: Int -> (Int, Int) -> [Char]
adj_solver n (x, y) =
  if mod (x + y) 2 == 1
    then solver n (x, y)
    else 'R' : (solver n (x -1, y))

main = do
  (n : _) <- L.map read . words <$> getLine :: IO [Int]
  inputs <- forM [1 .. n] (\_ -> (return . (\(x : y : []) -> (x, y)) . (map read) . words) =<< getLine)
  case odd_even inputs of
    (False, _) -> do
      putStr "-1\n"
    (True, b) -> do
      putStr $ (if b then show (d + 1) else show d)
      putStr "\n"
      putStr $ concat (intersperse " " (map (\x -> show x) ((if b then [1] else []) ++ (bit d))))
      putStr "\n"
      forM_
        inputs
        ( \(x, y) -> do
            case b of
              True -> putStr $ 'R' : solver d (x -1, y)
              False -> putStr $ solver d (x, y)
            putStr "\n"
        )
  where
    d = 31

solver_test :: Int -> [Char] -> (Int, Int)
solver_test n ls =
  let fl = zip [0 .. n -1] ls
   in let x = sum [if c == 'R' then 2 ^ i else (- (2 ^ i)) | (i, c) <- fl, c == 'L' || c == 'R']
       in let y = sum [if c == 'U' then 2 ^ i else (- (2 ^ i)) | (i, c) <- fl, c == 'U' || c == 'D']
           in (x, y)
