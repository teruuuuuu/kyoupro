{-# LANGUAGE OverloadedStrings #-}
module Main where
import Test.HUnit

import AtCoder.Beginner.Q111.DSpec

main :: IO ()
main = do
  runTestTT $ TestList
    [
      beginnerQ11DTest
    ]
  return ()
