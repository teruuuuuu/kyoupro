use std;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse().ok().unwrap()
  }
  fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
  }
  fn solve(mut i: usize) -> i32 {
    let mut ans = 1;
    let mut history = [false; 1000001];
    history[i] = true;
    fn next(x: usize) -> usize {
      match x % 2 {
        0 => x / 2,
        _ => 3 * x + 1
      }
    }
    loop {
      i = next(i);
      ans += 1;
      if history[i] {
        break;
      } else {
        history[i] = true;
      }
    }
    ans
  }
  let input = read_vec::<usize>();
  println!("{}", solve(input[0]));
}

