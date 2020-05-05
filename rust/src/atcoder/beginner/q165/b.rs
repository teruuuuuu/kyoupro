use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }
  let k = read::<i128>();
  let mut current = 100 as i128;
  let mut ans = 0;
  while current < k {
    current *= 101;
    current /= 100;
    ans += 1;
  }
  println!("{:?}", ans);
}

// #[test]
// fn test() {
//   main();
// }
