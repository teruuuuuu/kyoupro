use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }

  const RADIX: u32 = 10;

  let mut s: String = read::<String>();
  let mut ans = s.chars().fold(Option::Some(0), |acc, cur| match acc {
    Some(x) => match cur.to_digit(RADIX) {
      Some(y) => Option::Some(x * 10 + y * 2),
      _ => Option::None,
    },
    _ => Option::None,
  });

  match ans {
    Some(a) => println!("{:?}", a),
    _ => println!("error"),
  }
}

// https://atcoder.jp/contests/past201912-open/tasks/past201912_a
// #[test]
// fn test() {
//   main();
// }
