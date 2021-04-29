use std;

use std::collections::{VecDeque, HashSet, HashMap};
use std::cmp::max;

fn read_line() -> String {
  let mut buf = String::new();
  std::io::stdin().read_line(&mut buf);
  buf
}

pub fn main() {
  fn read_hwm() -> (i32, i32, i32) {
    let a:Vec<i32> = read_line().split_whitespace().map(|e| e.parse().unwrap()).collect();
    (a[0], a[1], a[2])
  }

  fn read_hw() -> (i32, i32) {
    let a:Vec<i32> = read_line().split_whitespace().map(|e| e.parse().unwrap()).collect();
    (a[0], a[1])
  }

  let (_, _, m) = read_hwm();
  let mut h_map = HashMap::new();
  let mut h_max: i32 = 0;
  let mut w_map = HashMap::new();
  let mut w_max: i32 = 0;
  let mut set = HashSet::<(i32, i32)>::new();

  for _ in 0..m {
    let hw = read_hw();
    *h_map.entry(hw.0).or_insert(0) += 1;
    *w_map.entry(hw.1).or_insert(0) += 1;
    h_max = max(h_max, *h_map.get(&hw.0).unwrap());
    w_max = max(w_max, *w_map.get(&hw.1).unwrap());
    set.insert(hw);
  }

  let h_vec:Vec<i32> = h_map.into_iter().filter(|a| (*a).1.eq(&h_max)).map(|a|a.0).collect();
  let w_vec:Vec<i32> = w_map.into_iter().filter(|a| (*a).1.eq(&w_max)).map(|a|a.0).collect();


  let h_len = (&h_vec).len();
  let w_len = (&w_vec).len();
  let tyouhuku = {
    let mut find = false;
    for i in 0..h_len as usize {
      for j in 0..w_len as usize {
        if !set.contains(&((&h_vec)[i], (&w_vec)[j])) {
          find = true;
          break;
        }
      }
      if find {break;}
    }
    !find
  };
  println!("{}", if tyouhuku {h_max+w_max-1} else {h_max+w_max})
}
