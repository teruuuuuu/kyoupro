use std::io::stdin;
use std::io::Read;
use std::io::StdinLock;
use std::str::FromStr;

fn read<T: FromStr>(s: &mut StdinLock) -> Option<T> {
  let s = s
    .by_ref()
    .bytes()
    .map(|c| c.unwrap() as char)
    .skip_while(|c| c.is_whitespace())
    .take_while(|c| !c.is_whitespace())
    .collect::<String>();
  s.parse::<T>().ok()
}

fn read_line<T: std::str::FromStr>() -> T {
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).ok();
  s.trim().parse::<T>().ok().unwrap()
}

fn read_vec<T: std::str::FromStr>() -> Vec<T> {
  read_line::<String>()
    .split_whitespace()
    .map(|e| e.parse().ok().unwrap())
    .collect()
}
