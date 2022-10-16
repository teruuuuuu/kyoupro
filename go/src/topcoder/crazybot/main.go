package main

import (
  "fmt"
)

type direction struct {
  x int
  y int
  prob float64
}

type crazy_bot struct {
  grid [100][100]int
  dir  [4]direction
}

func makeCb(east int, west int, south int, north int) *crazy_bot {
  dir1 := direction{x: 1, y:0, prob: float64(east)/100.0}
  dir2 := direction{x: -1, y:0, prob: float64(west)/100.0}
  dir3 := direction{x: 0, y:1, prob: float64(south)/100.0}
  dir4 := direction{x: 0, y:-1, prob: float64(north)/100.0}

  grid := [100][100]int {{0}}
  dir := [4]direction {dir1, dir2, dir3, dir4}
  cb := crazy_bot{grid: grid, dir: dir}

  return &cb
}

func solve(cb *crazy_bot, n int, x int, y int) float64 {
  if cb.grid[x][y] == 1 {
    return 0
  } else if n == 0 {
    return 1
  }
  cb.grid[x][y] = 1
  ret := 0.0
  for i := 0; i < len(cb.dir); i++ {
    ret += solve(cb, n-1, x+cb.dir[i].x, y+cb.dir[i].y) * cb.dir[i].prob
  }
  cb.grid[x][y] = 0
  return ret
}

func main(){
  var (
    N int;
    east int;
    west int;
    south int;
    north int;
  )
  fmt.Scan(&N)
  fmt.Scan(&east)
  fmt.Scan(&west)
  fmt.Scan(&south)
  fmt.Scan(&north)

  cb := makeCb(east, west, south, north)

  fmt.Println(solve(cb, N, 50, 50))
}
