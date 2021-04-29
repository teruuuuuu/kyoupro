use std;
use std::rc::Rc;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse::<T>().ok().unwrap()
  }
  fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
  }

  let n = read::<String>();
  let ans:u32 = n.chars().fold(0, |a, b| a + b.to_digit(10).unwrap()) % 9;
  println!("{}", if ans == 0 {"Yes"} else {"No"});

}
