use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }

  let n = read::<usize>();
  let mut a = vec![0; n];
  for _ in (0..n) {
    let i = read::<usize>();
    a[i - 1] = a[i - 1] + 1;
  }
  let mut x = 0;
  let mut y = 0;
  let mut not_correct = false;

  for i in (0..n) {
    if a[i] >= 2 {
      x = i + 1;
      not_correct = true;
    }
    if a[i] == 0 {
      y = i + 1;
      not_correct = true;
    }
  }
  if not_correct {
    println!("{:?} {:?}", x, y);
  } else {
    println!("Correct");
  }
}

// https://atcoder.jp/contests/past201912-open/tasks/past201912_d
// #[test]
// fn test() {
//   main();
// }
