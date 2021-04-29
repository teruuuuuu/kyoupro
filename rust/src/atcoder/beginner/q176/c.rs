use std;

pub fn main() {

  fn read() -> String {
    let mut buf = String::new();
    std::io::stdin().read_line(&mut buf);
    buf
  }

  fn read_vec_i64() -> Vec<i64> {
    read().split_whitespace().
      map(|e| e.parse().unwrap()).collect()
  }
  let _ = read();
  let a = read_vec_i64();

  let mut ans:i64 = 0;
  let mut high:i64 = 0;
  for i in a {
    if high > i {
      ans += high - i;
    } else {
      high = i;
    }
  }
  println!("{}", ans);
}
