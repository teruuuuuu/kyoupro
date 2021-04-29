use std;
// use std::collections::HashSet;

trait SNS {
  fn show_result(&mut self);
  fn follow(&mut self, a: usize, b: usize);
  fn follow_back(&mut self, a: usize);
  fn follow_follow(&mut self, a: usize);
}

impl SNS for Vec<Vec<i32>> {
  fn show_result(&mut self) {
    for a in self {
      println!(
        "{}",
        a.iter()
          .map(|x| if *x == 0 { 'N' } else { 'Y' })
          .collect::<String>()
      );
    }
  }
  fn follow(&mut self, a: usize, b: usize) {
    self[a][b] = 1;
  }

  fn follow_back(&mut self, a: usize) {
    let mut vec = Vec::new();
    let mut i: usize = 0;
    for x in self.iter() {
      if x[a] == 1 && i != a {
        vec.push(i);
      }
      i += 1;
    }

    for x in vec {
      self[a][x] = 1;
    }
  }

  fn follow_follow(&mut self, a: usize) {
    let mut vec = Vec::new();
    let mut i = 0;
    for x in self[a].iter() {
      if *x == 1 {
        vec.push(i);
      }
      i += 1;
    }

    let mut set = std::collections::HashSet::new();
    for y in vec {
      let mut i: usize = 0;
      for j in self[y].iter() {
        if *j == 1 && i != a {
          set.insert(i);
        }
        i += 1;
      }
    }

    for z in set {
      self[a][z] = 1;
    }
  }
}

pub fn main() {
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

  let nq = read_vec::<i32>();
  let n = nq[0];
  let q = nq[1];

  let mut s = vec![vec![0; n as usize]; n as usize];
  for i in 0..q {
    let f = read_vec::<usize>();
    if f[0] == 1 {
      s.follow(f[1] - 1, f[2] - 1);
    } else if f[0] == 2 {
      s.follow_back(f[1] - 1);
    } else if f[0] == 3 {
      s.follow_follow(f[1] - 1);
    }
  }
  s.show_result();
}

// https://atcoder.jp/contests/past201912-open/tasks/past201912_e
// #[test]
// fn test() {
//   main();
// }
