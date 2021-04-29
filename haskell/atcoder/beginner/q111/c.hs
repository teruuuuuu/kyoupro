import Data.IntMap as M
import Data.List as L

keyCounts :: [Int] -> (((IntMap Int), Int), ((IntMap Int), Int))
keyCounts = L.foldl' (\((a, ac), b) k -> (b, ((M.insertWith (+) k 1 a), ac + 1))) ((M.empty, 0), ((M.empty), 0))

sortIntMap :: ((IntMap Int), Int) -> ([(Int, Int)], Int)
sortIntMap (a, ac) = (sortBy (\a b -> compare (snd a) (snd b)) $ foldlWithKey (\ks k x -> (k, ac - x) : ks) [] a, ac)

costs :: ([(Int, Int)], Int) -> ([(Int, Int)], Int) -> Int
costs ([], a) ([], b) = a + b
costs ([], a) ((x, y) : k, b) = a + y
costs ((x, y) : k, a) ([], b) = b + y
costs ((t, u) : k, a) ((v, w) : l, b) =
  if t == v
    then if costs ((t, u) : k, a) (l, b) < costs (k, a) ((v, w) : l, b) then costs ((t, u) : k, a) (l, b) else costs (k, a) ((v, w) : l, b)
    else u + w

main = do
  n <- L.map read . words <$> getLine :: IO [Int]
  (m) <- L.map read . words <$> getLine :: IO [Int]
  print $ (\(a, b) -> costs a b) $ (\(a, b) -> (sortIntMap a, sortIntMap b)) $ keyCounts m
