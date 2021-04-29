use std;

use std::collections::{VecDeque, HashSet, HashMap};
use std::cmp::max;
use std::str::FromStr;

fn read_line() -> String {
  let mut buf = String::new();
  std::io::stdin().read_line(&mut buf);
  buf
}

fn current_point(x: i32, y: i32, point: i32) -> (i32, i32, i32) {
  if x < y {(x,y,point)} else {(y,x,point)}
}

pub fn main() {
  let n = read_line().trim().parse::<i32>().unwrap();
  let a = read_line().split_whitespace().map(|e| e.parse::<i32>().unwrap()).collect::<Vec<i32>>();
  let mut dp = HashMap::<i32, Vec<(i32, i32, i32)>>::new();

  let mut current_points = vec![current_point(a[0], a[1], 0)];

  for i in (0 as usize)..(n-1) as usize {
    let (a3, a4, a5) = (a[i*3+2], a[i*3+3], a[i*3+4]);
    println!("{}{}{}",a3,a4,a5);
  }
}
