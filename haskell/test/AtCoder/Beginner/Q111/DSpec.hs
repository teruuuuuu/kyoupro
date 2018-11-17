{-# LANGUAGE OverloadedStrings #-}
module AtCoder.Beginner.Q111.DSpec where
import Test.HUnit

import AtCoder.Beginner.Q111.D


beginnerQ11DTest :: Test
beginnerQ11DTest = TestList
  [
    "od or even test 1" ~: odd_even [(1, 3), (3, 3)] ~?= (True, True)
  , "od or even test 2" ~: odd_even [(1, 2), (3, 3)] ~?= (False, False)
  , "od or even test 3" ~: odd_even [(3, 2), (3, 4)] ~?= (True, False)
  , "accum test 1" ~: ls_accum (\b -> (b+1, b-1))  (\b -> b > 10) 5 ~?= [4, 5, 6, 7, 8, 9]
  , "bin expand test 1" ~: ls_accum (\ i -> (div i 2 , (mod i 2)==1) ) (0==) 38 ~?= [False, True, True, False, False, True]
  , "bin expand test 2" ~: sigma_bit 31 38 ~?= [False,True,False,False,True,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,True]
  , "sigma bits" ~: sigma_bit 3 9 ~?= [False, False, False, True]
  , "solver test 1" ~: solver 4 (2, 3) ~?= ['D', 'R', 'D', 'U']
  , "solver test 2" ~: solver_test 4 ( solver 4 (2, 3) ) ~?= (2, 3)
  ]

