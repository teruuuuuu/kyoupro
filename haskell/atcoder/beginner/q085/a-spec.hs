import Test.HUnit

-- test1 = TestCase (assertEqual "for (foo 3)," (1, 2) (foo 3))

main = do
  runTestTT $ TestList ["od or even test 1" ~: True ~?= True]
