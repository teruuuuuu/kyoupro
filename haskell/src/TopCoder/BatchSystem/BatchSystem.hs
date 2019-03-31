module TopCoder.BatchSystem.BatchSystem where

import Data.List as L
import qualified Data.Map as Map
import Data.Ord (comparing)

getLineTrans :: ([String] -> [a]) -> IO[a]
getLineTrans trans = do
  input <- getLine::IO[Char]
  let ss = words input
  let ret = trans ss
  return ret

getInts :: IO[Int]
getInts = getLineTrans (\words -> L.map read words :: [Int])

getStrings :: IO[String]
getStrings = getLineTrans (\words -> words)

usersIndex :: [String] -> Map.Map String [Int]
usersIndex users = foldl (\acc cur -> Map.insert (fst cur)
    ((case Map.lookup (fst cur) acc of
      Just x -> x
      Nothing -> []
      ) ++ [(snd cur)])  acc
  ) (Map.fromList []) $ zip users [0..]

usersCost :: Map.Map String [Int] -> [Int] -> [(String, Int)]
usersCost userWithI costs = L.map (\user -> ((fst user),
      foldl (\acc cur -> acc + costs !! cur) 0 (snd user)
  )) $ Map.toList userWithI

exec :: [Int] -> [String] -> [Int]
exec durations users = do
  let userWithI = usersIndex users
  let userSort = map (\a -> fst a) $ sortBy (comparing snd) $ usersCost userWithI durations
  foldl (\acc cur -> acc ++ case Map.lookup cur userWithI of
      Just x -> x
      Nothing -> []
    ) [] userSort

answer = do
  print "start"
  durations <- getInts
  users <- getStrings
  putStrLn $ L.intercalate " " $ map (\a -> show a) $ exec durations users
  print "end"
