use std;
use std::collections::HashSet;
use std::collections::VecDeque;

pub fn main() {
  fn read<T: std::str::FromStr>() -> T {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).ok();
    s.trim().parse().ok().unwrap()
  }
  fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
  }
  fn solve(k: usize, mut sushis: Vec<(u32, u32)>) -> u64 {
    let mut ans = 1;
    sushis.sort_by(|a, b| b.1.cmp(&a.1));

    let mut point: u64 = 0;
    let mut types: u64 = 0;
    let mut type_set:HashSet<u32> = HashSet::new();
    let mut kabri_stack: Vec<u32> = Vec::new();
    let mut kouho_que: VecDeque<u32> = VecDeque::new();

    for i in 0..k {
      point += sushis[i].1 as u64;
      if type_set.contains(&sushis[i].0) {
        kabri_stack.push(sushis[i].1);
      } else {
        type_set.insert(sushis[i].0);
        types += 1;
      }
    }
    ans = point + types * types;
    for i in k..sushis.len() {
      if !type_set.contains(&sushis[i].0) {
        kouho_que.push_back(sushis[i].1);
        type_set.insert(sushis[i].0);
      }
    }
    while !kabri_stack.is_empty() && !kouho_que.is_empty() {
      point -= kabri_stack.pop().unwrap() as u64;
      point += kouho_que.pop_front().unwrap() as u64;
      types += 1;
      let temp = point + types * types;
      if temp > ans {
        ans = temp;
      }
    }
    ans
  }

  let line: Vec<usize>  = read_vec::<usize>();
  let (n, k) = (line[0], line[1]);
  let mut sushis = Vec::new();
  for _ in 0..n{
    let line: Vec<u32>  = read_vec::<u32>();
    sushis.push((line[0], line[1]));
  }
  println!("{}", solve(k, sushis));
}

