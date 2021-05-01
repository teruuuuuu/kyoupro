use std;
use core::cmp;

fn read<T: std::str::FromStr>() -> T {
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).ok();
  s.trim().parse().ok().unwrap()
}

fn read_vec<T: std::str::FromStr>() -> Vec<T> {
  read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
}

fn solve(n: i32, k: i32, h: Vec<i32>) -> i32 {
  const N_MAX: usize = 100000;
  let mut dp:[i32; N_MAX] = [-1; N_MAX];

  for i in 0..n {
    for j in 1..cmp::min(k + 1, n - i) {
      let i_usize:usize = i as usize;
      let ij_usize = (i+j) as usize;
      let next = if dp[i_usize] == -1 {
        (h[i_usize] - h[ij_usize]).abs()
      } else {
        dp[i_usize] + (h[i_usize] - h[ij_usize]).abs()
      };

      dp[ij_usize] = if dp[ij_usize] == -1 || dp[ij_usize] > next {
        next
      } else {
        dp[ij_usize]
      }
    }
  }
  dp[(n-1) as usize]
}

pub fn main() {
  let n = read_vec::<i32>();
  let h = read_vec::<i32>();
  println!("{}", solve(n[0], n[1], h));
}
