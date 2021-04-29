use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }
  let n = read::<usize>();
  let mut a: Vec<i32> = vec![0; n as usize];

  for i in (0..n) {
    a[i as usize] = read::<i32>();
  }

  for i in (0..n - 1) {
    let b = a[i + 1] - a[i];
    if b == 0 {
      println!("stay");
    } else if b > 0 {
      println!("up {:?}", b);
    } else {
      println!("down {:?}", -b);
    }
  }
}

// https://atcoder.jp/contests/past201912-open/tasks/past201912_b
// #[test]
// fn test() {
//   main();
// }
