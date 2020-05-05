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
  let k = read::<i32>();
  let ab = read_vec::<i32>();
  let a = ab[0];
  let b = ab[1];

  if (k - (a % k)) % k <= b - a {
    println!("OK");
  } else {
    println!("NG");
  }
}

// #[test]
// fn test() {
//   main();
// }
