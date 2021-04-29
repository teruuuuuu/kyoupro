use std::cmp::min;

fn read_line<T: std::str::FromStr>() -> T {
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).ok();
  s.trim().parse::<T>().ok().unwrap()
}

fn read_vec<T: std::str::FromStr>() -> Vec<T> {
  read_line::<String>()
    .split_whitespace()
    .map(|e| e.parse().ok().unwrap())
    .collect()
}

fn main() {
  let x = read_vec::<i64>();
  let a = x[0];
  let b = x[1];
  let n = x[2];

  let x = min(b - 1, n);
  let ans = a * x / b;
  println!("{:?}", ans)
}

// #[test]
// fn test() {
//   main();
// }
