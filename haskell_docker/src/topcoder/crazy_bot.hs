-- https://archive.topcoder.com/ProblemStatement/pm/10095
import qualified Data.Set as Set

data Rates = Rates
  { eastRate :: Float
  , westRate :: Float
  , southRate :: Float
  , northRate :: Float
  } deriving (Show)

data Position = Position
  { x :: Int
  , y :: Int
  } deriving (Show, Eq, Ord)

type PositionSet = Set.Set Position

robotMove :: Int -> PositionSet -> Position -> Rates -> Float
robotMove n positionSet position rates
    | Set.member position positionSet = 0.0
    | n == 0 = 1.0
    | otherwise =
        let newSet = Set.insert position positionSet
            east = robotMove (n - 1) newSet (Position (x position + 1) (y position)) rates
            west = robotMove (n - 1) newSet (Position (x position - 1) (y position)) rates
            south = robotMove (n - 1) newSet (Position (x position) (y position + 1)) rates
            north = robotMove (n - 1) newSet (Position (x position) (y position - 1)) rates
        in east * eastRate rates + west * westRate rates + south * southRate rates + north * northRate rates

main :: IO ()
main = do
    n <- readLn :: IO Int
    eastRateInput <- readLn >>= \inputInt -> return (fromIntegral (inputInt :: Int) / 100.0 :: Float)
    westRateInput <- readLn >>= \inputInt -> return (fromIntegral (inputInt :: Int) / 100.0 :: Float)
    southRateInput <- readLn >>= \inputInt -> return (fromIntegral (inputInt :: Int) / 100.0 :: Float)
    northRateInput <- readLn >>= \inputInt -> return (fromIntegral (inputInt :: Int) / 100.0 :: Float)
    let rates = Rates { 
        eastRate = eastRateInput, 
        westRate = westRateInput, 
        southRate = southRateInput, 
        northRate = northRateInput }
    print $ robotMove n Set.empty Position {x=0, y=0} rates