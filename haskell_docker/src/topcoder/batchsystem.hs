-- https://archive.topcoder.com/ProblemStatement/pm/10808

import Data.Char (isDigit)
import Data.List (sortBy)
import Data.Ord (comparing)
import qualified Data.Map as Map

parseInput :: String -> [Int]
parseInput input = map read $ words $ map (\c -> if isDigit c then c else ' ') input :: [Int]

parseName :: String -> String -> Maybe (String, String)
parseName input rest =
  case (length input > 2 && not (null input) && '"' == last input && '"' == head input, null rest) of
    (True,_) -> Just (reverse . init $ tail input, rest)
    (_,False) -> parseName ((head rest):input) (tail rest)
    (_,True) -> Nothing

skipSpace :: String -> String
skipSpace (' ':xs) = skipSpace xs
skipSpace xs = xs

skipComma :: String -> String
skipComma (',':xs) = skipComma xs
skipComma xs = xs

skipSeparator :: String -> String
skipSeparator = skipSpace . skipComma . skipSpace

collectNames :: String -> Maybe ([String], String)
collectNames input = collect input []
  where
    collect rest acc = do
      let result = parseName "" rest
      case result of
        Just (name, nextRest) -> collect (skipSeparator nextRest) (name : acc)
        Nothing -> Just (reverse acc, rest)


parseNames :: String -> Maybe ([String], String)
parseNames input = do
  rest1 <- if not (null input) && (head $ skipSpace input) == '{' then Just (tail $ skipSpace input) else Nothing
  (names, rest2) <- collectNames $ skipSpace rest1
  rest3 <- if not (null rest2) && head rest2 == '}' then Just (tail rest2) else Nothing
  return (names, rest3)

fromMaybe :: a -> Maybe a -> a
fromMaybe d x = case x of {Nothing -> d;Just v  -> v}

zipWithIndex :: [a] -> [b] -> [(Int, a, b)]
zipWithIndex xs ys = [(i, x, y) | (i, (x, y)) <- zip [0..] (zip xs ys)]

sumByString :: [(String, Int)] -> [(String, Int)]
sumByString tuples = Map.toList $ Map.fromListWith (+) [(name, cost) | (name, cost) <- tuples]

groupByString :: [(Int, String)] ->  Map.Map String [Int]
groupByString tuples = Map.map reverse $ Map.fromListWith (++) [(name, [i]) | (i, name) <- tuples]


main :: IO ()
main = do
  -- print "start"
  input <- parseInput <$> getLine
  -- print input
  (names,_) <- fromMaybe ([], "") <$> parseNames <$> getLine
  -- print names
  let coustSum = sumByString $ zip names input
  -- print $ coustSum
  let nameOrder = map fst $ sortBy (comparing snd) coustSum
  -- print $ nameOrder
  let nameMap = groupByString $ zip [0..] names
  -- print $ nameMap
  let result = foldl (\acc name -> acc ++ (fromMaybe [] $ Map.lookup name nameMap)) [] nameOrder
  putStrLn $ unwords $ map show result
  -- print "end"



{--
1
{400, 100, 100, 100}
{"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"}
Returns: {3, 1, 2, 0 }

2
{200, 200, 200}
{"Gil", "Sarah", "Warrick"}
Returns: {0, 1, 2 }

3
{100, 200, 50}
{"Horatio Caine", "horatio caine", "YEAAAAAAH"}
Returns: {2, 0, 1 }

4
{1000000000,1000000000,1000000000,1000000000,1,2,3}
{"X","X","X","X","Y","Y","Y"}
Returns: {4, 5, 6, 0, 1, 2, 3 }
[overflow]

5
{4,4,4,4,5,5,5,5,3,3,3,3,3}
{"X","x","X","x","X","x","X","x","X","x","X","x","X"}
Returns: {1, 3, 5, 7, 9, 11, 0, 2, 4, 6, 8, 10, 12 }
--}