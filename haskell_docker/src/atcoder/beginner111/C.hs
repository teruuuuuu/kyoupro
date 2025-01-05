module Main where 
import qualified Data.List as L
import qualified Data.Map as M


-- 偶数番目と奇数番目の数値の登場回数をカウントする関数
countEvenOdd :: [Int] -> (M.Map Int Int, M.Map Int Int)
countEvenOdd xs = L.foldl' updateCounts (M.empty, M.empty) (zip [0..] xs)
  where
    updateCounts (evenMap, oddMap) (i, x)
      | even i    = (M.insertWith (+) x 1 evenMap, oddMap)
      | otherwise = (evenMap, M.insertWith (+) x 1 oddMap)

-- タプルの各要素に sortMapByValue を適用する関数
sortCounts :: (M.Map Int Int, M.Map Int Int) -> ([(Int, Int)], [(Int, Int)])
sortCounts (evenMap, oddMap) = (sortMapByValue evenMap, sortMapByValue oddMap)

-- M.Map Int Int を値でソートした (Int, Int) のリストに変換する関数
sortMapByValue :: M.Map Int Int -> [(Int, Int)]
sortMapByValue m = L.reverse . L.sortBy (\(_, v1) (_, v2) -> compare v1 v2) $ M.toList m

solve :: [(Int, Int)] -> [(Int, Int)] -> Int
solve [] [] = 0
solve [] oddCounts = snd . head $ oddCounts
solve evenCounts [] = snd . head $ evenCounts
solve (evenCountsHead:evenCountsTail) (oddCountsHead:oddCountsTail)
  | fst evenCountsHead == fst oddCountsHead = max (solve evenCountsTail (oddCountsHead:oddCountsTail)) (solve (evenCountsHead:evenCountsTail) oddCountsTail)
  | otherwise = snd evenCountsHead + snd oddCountsHead


main :: IO ()
main = do
  n <- readLn :: IO Int
  (evenCounts, oddCounts) <- sortCounts .  countEvenOdd <$> L.map read . words <$> getLine 
  print $ n - solve evenCounts oddCounts
