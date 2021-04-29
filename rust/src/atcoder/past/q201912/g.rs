use std;
use std::collections::HashMap;

#[derive(Debug)]
struct PearMap {
  pub map: HashMap<i16, i32>,
}

impl PearMap {
  fn new() -> Self {
    PearMap {
      map: HashMap::new(),
    }
  }

  pub fn insert(&mut self, i: i16, j: i16, value: i32) {
    self.map.insert(Self::to_key(i, j), value);
  }

  pub fn get(&self, i: i16, j: i16) -> Option<&i32> {
    self.map.get(&Self::to_key(i, j))
  }

  pub fn score(&self, vec: &Vec<i16>) -> i64 {
    let mut point = 0 as i64;
    for (i, val1) in vec.iter().enumerate() {
      for j in i + 1..vec.len() {
        if *val1 == *vec.get(j).unwrap() {
          point += *self.get(i as i16 + 1, j as i16 + 1).unwrap() as i64;
        }
      }
    }
    point
  }

  fn to_key(i: i16, j: i16) -> i16 {
    if i < j {
      i * 100 + j
    } else {
      j * 100 + i
    }
  }
}

fn read<T: std::str::FromStr>() -> T {
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).ok();
  s.trim().parse::<T>().ok().unwrap()
}

fn read_vec<T: std::str::FromStr>() -> Vec<T> {
  read::<String>()
    .split_whitespace()
    .map(|e| e.parse().ok().unwrap())
    .collect()
}

pub fn main() {
  let mut map = PearMap::new();
  let n = read::<i16>();
  for i in 1..n {
    let a = read_vec::<i32>();
    for (j, val) in a.iter().enumerate() {
      map.insert(i, i + j as i16 + 1, *val);
    }
  }

  let mut vec = vec![1; n as usize];
  let mut ans: Option<i64> = Option::None;
  let mut index = 0;
  let mut countup = false;
  loop {
    if !countup {
      let score = map.score(&vec);
      match ans {
        None => ans = Option::Some(score),
        Some(x) => {
          if x < score {
            ans = Option::Some(score)
          }
        }
      }
    }
    if countup {
      if index >= n {
        break;
      } else if *vec.get(index as usize).unwrap() == 3 {
        vec[index as usize] = 1;
        index += 1;
      } else {
        vec[index as usize] += 1;
        index = 0;
        countup = false;
      }
    } else {
      if vec[index as usize] == 3 {
        vec[index as usize] = 1;
        index += 1;
        countup = true;
      } else {
        vec[index as usize] += 1;
        index = 0;
      }
    }
  }
  println!("{:?}", ans.unwrap());
}

// #[test]
// fn test() {
//   main();
// }
