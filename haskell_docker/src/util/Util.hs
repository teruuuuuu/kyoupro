module Util where

times :: Int -> (a -> a) -> a -> a
times n f = inner 0
  where
    inner i !s
      | i >= n = s
      | otherwise = inner (i + 1) $! f s