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

  let nk = read_vec::<i32>();
  let n = nk[0];
  let k = nk[1];

  let mut vec: Vec<i32> = vec![0; n as usize];
  for i in 0..k {
    read::<String>();
    let a = read_vec::<i32>();
    for j in a {
      vec[(j - 1) as usize] = 1;
    }
  }

  let mut ans = 0;
  for k in vec {
    if k == 0 {
      ans = ans + 1;
    }
  }
  println!("{:?}", ans);
}

// #[test]
// fn test() {
//   main();
// }
