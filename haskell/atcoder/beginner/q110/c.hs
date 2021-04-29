import Control.Applicative
import Control.Monad
import Control.Monad (mfilter)
import Data.List
import qualified Data.Map.Strict as M

data TreeDict k v
  = TDEmpty
  | TDNode k v (TreeDict k v) (TreeDict k v)
  deriving (Show)

addDict :: Ord k => k -> v -> TreeDict k v -> TreeDict k v
addDict k v TDEmpty = TDNode k v TDEmpty TDEmpty
addDict k v (TDNode k' v' l r)
  | k < k' = TDNode k' v' (addDict k v l) r
  | k > k' = TDNode k' v' l (addDict k v r)
  | otherwise = TDNode k' v l r

lookup' :: Ord k => k -> TreeDict k v -> Maybe v
lookup' _ TDEmpty = Nothing
lookup' k (TDNode k' v' l r)
  | k < k' = lookup' k l
  | k > k' = lookup' k r
  | otherwise = Just v'

toDict :: (Ord a) => a -> a -> TreeDict a a -> Maybe (TreeDict a a)
toDict k v tree = do
  case lookup' k tree of
    Nothing -> Just $ addDict k v tree
    Just x -> if x == v then Just tree else Nothing

fKeyToDic :: (Ord a) => (a, a) -> TreeDict a a -> Maybe (TreeDict a a)
fKeyToDic x tree = toDict (fst x) (snd x) tree

sKeyToDic :: (Ord a) => (a, a) -> TreeDict a a -> Maybe (TreeDict a a)
sKeyToDic x tree = toDict (snd x) (fst x) tree

tArrayToDic :: (Ord a) => [(a, a)] -> ((a, a) -> TreeDict a a -> Maybe (TreeDict a a)) -> Maybe (TreeDict a a)
tArrayToDic a f = do
  foldl
    ( \acc a -> case acc of
        Just x -> f a x
        Nothing -> Nothing
    )
    (Just TDEmpty)
    a

tArrayToFDic :: (Ord a) => [(a, a)] -> Maybe (TreeDict a a)
tArrayToFDic a = tArrayToDic a fKeyToDic

tArrayToSDic :: (Ord a) => [(a, a)] -> Maybe (TreeDict a a)
tArrayToSDic a = tArrayToDic a sKeyToDic

main :: IO ()
main = do
  x <- getLine
  y <- getLine
  let a = zipWith (\x y -> (x, y)) x y
  putStrLn $ case tArrayToFDic a of
    Just x -> case tArrayToSDic a of
      Just y -> "Yes"
      Nothing -> "No"
    Nothing -> "No"
