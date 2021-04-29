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

fn vec_to_num(digit: i32, vec: &[i32]) -> i32 {
  if (vec.len() == 0) {
    0
  } else {
    digit * vec.first().unwrap() + vec_to_num(digit * 10, &vec[1..])
  }
}

fn solve(n: i32, h: Vec<i32>) -> i32 {
  match h {
    _ if h.len() <= (1 as usize) => 0,
    _ if h.len() == (2 as usize) => (h[0] - h[1]).abs(),
    _ => {
      let mut dp0 = (h[0] - h[1]).abs();
      let mut dp1 = (h[0] - h[2]).abs();
      for i in 1..n - 2 {
        let ndp0 = cmp::min(dp1, dp0 + (h[i as usize] - h[(i + 1) as usize]).abs());
        let ndp1 = dp0 + (h[i as usize] - h[(i + 2) as usize]).abs();
        dp0 = ndp0;
        dp1 = ndp1;
      }
      cmp::min(dp1, dp0 + (h[(n - 2) as usize] - h[(n - 1) as usize]).abs())
    }
  }
}

pub fn main() {
  let n = read::<i32>();
  let h = read_vec::<i32>();
  println!("{}", solve(n, h));
}
