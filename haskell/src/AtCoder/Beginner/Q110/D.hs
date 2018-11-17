module AtCoder.Beginner.Q110.D where
import Control.Monad
import Data.List as L
import Data.IntMap as M

primes :: Integral a => [a]
primes = takeWhile (<31623) $ L.map fromIntegral ([2, 3] ++ primes' :: [Int])
    where
      primes' = 5 : sieve [] primes' 7
      sieve divs (x : xs) n = ps ++ sieve (divs ++ [x]) xs (x * x)
          where
            isPrime m = and [rem m x /= 0 | x <- divs]
            ps = L.filter isPrime ns
            ns = [y + z | y <- [n, n + 6 .. x * x - 2], z <- [0, 4]]

fac :: [Integer]->M.IntMap Integer->Integer->M.IntMap Integer
fac _ m 1 = m
fac [] m n = M.insert (fromIntegral n) 1 m
fac pa@(p:pr) m n
    |mod n (fromIntegral p)==0=fac pa (M.insertWith(+) (fromIntegral p) 1 m) (div n (fromIntegral p))
    |otherwise =fac pr m n

invmod p g = invmod' 1 0 p 0 1 g
    where invmod' px py pgcd x y gcd
            | m==0 = mod (x+g) g
            | True = invmod' x y gcd (px - (d*x)) (py - (d*y)) m
            where
                m = mod pgcd gcd
                d = div pgcd gcd

divmod a b p = mod (a * invmod b p) p

cmbmod n k p = L.foldl' (\a i->divmod (mod (a*(n-i+1)) p) i p) 1 [1..k]

sol 1 _ = 1
sol _ 1 = 1
sol n m = L.foldl' (\a b -> (a * cmbmod (b+n-1) b 1000000007) `mod` 1000000007) 1 fm
    where fm = elems $ fac primes M.empty m

main=do
    (n:m:_)<-L.map read . words<$>getLine::IO[Integer]
    print $ sol n m
