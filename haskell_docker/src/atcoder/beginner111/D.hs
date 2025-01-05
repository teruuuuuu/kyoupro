module Main where

import Control.Monad (forM, forM_)
import qualified Data.Set as Set
import Data.Bits (shiftL, (.&.))

notEqual :: Eq a => a -> a -> Bool
notEqual = (/=)

binaryNumbers :: Int -> [Int]
binaryNumbers n = map (1 `shiftL`) [0..n-1]

-- 指定されたビットが立っているかどうかを確認する関数
isBitSet :: Int -> Int -> Bool
isBitSet number bitPosition = (number .&. (1 `shiftL` bitPosition)) /= 0

armOperation :: Int -> Int -> [Char]
armOperation x y = map (\bitPosition -> operation (isBitSet xpy_binary bitPosition) (isBitSet xmy_binary bitPosition)) [0..31-1]
  where
    operation xpy_on xmy_on = case (xpy_on, xmy_on) of
      (True, True) -> 'R'
      (True, False) -> 'U'
      (False, True) -> 'D'
      (False, False) -> 'L'
    xpy = x + y
    xmy = x - y
    xpy_binary = (xpy + (1 `shiftL` 31) - 1) `div` 2
    xmy_binary = (xmy + (1 `shiftL` 31) - 1) `div` 2


main :: IO ()
main = do
  -- 数値 n を受け取る
  n <- readLn :: IO Int
  -- (Int, Int) のペアを n 個受け取る
  inputs <- forM [1..n] $ \_ -> do
    [x, y] <- map read . words <$> getLine  :: IO [Int]
    pure (x, y)
  let mod_sets = Set.fromList $ map(\(x, y) -> mod (abs x + y) 2) inputs
  if Set.size mod_sets `notEqual` 1 then do
    putStrLn "-1"
  else if Set.member 1 mod_sets then do
    putStrLn "31"
    putStrLn $ unwords $ map show $ binaryNumbers 31
    forM_ inputs $ \(x, y) -> do
      putStrLn $ armOperation x y
  else do
    putStrLn "32"
    putStrLn $ unwords $ map show $ 1 : binaryNumbers 31
    forM_ inputs $ \(x, y) -> do
      putStrLn $ 'R' : armOperation (x-1) y
