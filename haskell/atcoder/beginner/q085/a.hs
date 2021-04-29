main = getLine >>= (\x -> pure $ "2018" ++ drop 4 x) >>= putStrLn
