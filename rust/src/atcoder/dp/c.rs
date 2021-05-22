use std;
use core::cmp;
use proconio::input;

fn solve(abc: Vec<Vec<i32>>) -> i32 {
  let N = abc.len();
  let mut dp:[i32; 3] = [0; 3];
  dp[0] = abc[0][0];
  dp[1] = abc[0][1];
  dp[2] = abc[0][2];
  for i in 1..N {
    let dp0 = dp[0];
    let dp1 = dp[1];
    let dp2 = dp[2];
    dp[0] = cmp::max(dp1, dp2) + abc[i][0];
    dp[1] = cmp::max(dp0, dp2) + abc[i][1];
    dp[2] = cmp::max(dp0, dp1) + abc[i][2];
  }
  cmp::max(cmp::max(dp[0], dp[1]),dp[2])
}

pub fn main() {
  input! {
    N: usize,
    abc: [[i32; 3]; N]
  }
  println!("{}", solve(abc));
}
