use std;
use std::collections::HashMap;

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

fn get_min(x_opt: Option<i32>, y: i32) -> Option<i32> {
  match x_opt {
    None => Some(y),
    Some(x) => {
      if x < y {
        Some(x)
      } else {
        Some(y)
      }
    }
  }
}

pub fn main() {
  let n = read::<i32>();
  let c = read_vec::<i32>();
  let mut c_selled = [0; 200000];
  let q = read::<i32>();

  let mut min: Option<i32> = Option::None;
  let mut min_odd: Option<i32> = Option::None;

  let mut ans = 0;

  let mut all_selled:i64 = 0;
  let mut odd_selled:i64 = 0;
  for (i, x) in c.iter().enumerate() {
    min = get_min(min, *x);
    if i % 2 == 0 {
      min_odd = get_min(min_odd, *x);
    }
  }

  for _ in 0..q {
    let s: Vec<i32> = read_vec::<i32>();
    if s[0] == 1 {
      let index = (s[1] - 1) as usize;
      let num = s[2];
      let selled = if index % 2 == 0 {

      };
      c_selled[index] = c_selled[index] + num;
    // println!("type1: c[{:?}] [{:?}]", c[index], num);
    // if num <= c[index] {
    //   c[index] = c[index] - num;
    //   ans += num;
    //   min = get_min(min, c[index]);
    //   if index % 2 == 0 {
    //     min_odd = get_min(min_odd, c[index]);
    //   }
    // }
    } else if s[0] == 2 {
      println!("type2");
    } else if s[0] == 3 {
      println!("type3");
    }
  }
  println!("end {:?}", ans);
}

#[test]
fn test() {
  main();

  // 4
  // 5 3 3 5
  // 6
  // 1 2 1
  // 2 2
  // 2 2
  // 3 100
  // 3 1
  // 1 1 3
}
