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

  let nxt = read_vec::<i32>();
  let n = nxt.get(0).unwrap();
  let x = nxt.get(1).unwrap();
  let t = nxt.get(2).unwrap();

  println!("{}", (n/x + if n%x>0 {1} else {0}) * t);
}
