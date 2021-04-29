use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }

  let s = read::<String>();
  match s.as_str() {
    "ABC" => println!("ARC"),
    "ARC" => println!("ABC"),
    _ => println!(""),
  }
}

// #[test]
// fn test() {
//   main();
// }
