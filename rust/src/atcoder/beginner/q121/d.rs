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
    let ab = read_vec::<u64>();
    let a = ab[0];
    let b = ab[1];
    println!("{}", solve(a, b));
}

pub fn solve(a: u64, b: u64) -> u64 {
  f(a-1)^(f(b))
}
fn f(x: u64) -> u64{
  if x % 2 == 0 {
    x^(x/2%2)
  } else {
    f(x+1)^(x+1)
  }
}
