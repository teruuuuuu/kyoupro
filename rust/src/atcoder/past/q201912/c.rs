use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }
  fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read::<String>()
      .split_whitespace()
      .map(|e| e.parse().ok().unwrap())
      .collect()
  }

  let mut a = read_vec::<i32>();
  a.sort_by(|a, b| b.cmp(a));
  println!("{:?}", a[2]);
}

// https://atcoder.jp/contests/past201912-open/tasks/past201912_c
// #[test]
// fn test() {
//   main();
// }
