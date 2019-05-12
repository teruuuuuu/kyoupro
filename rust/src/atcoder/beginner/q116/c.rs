use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse().ok().unwrap()
  }
  fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
  }
  fn solve(input: Vec<i32>) -> i32 {
    let mut ans = input[0];
    for i in 1..input.len() {
      match input[i] - input[i-1] {
        x if x > 0 => ans += x,
        _ => {}
      };
    }
    ans
  }
  read_vec::<String>();
  let input = read_vec::<i32>();
  println!("{}", solve(input));
}

