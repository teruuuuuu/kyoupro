use std;
use std::cmp::Ordering;

fn read<T: std::str::FromStr>() -> T {
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).ok();
  s.trim().parse::<T>().ok().unwrap()
}

fn to_str_vec(s: &String) -> Vec<&str> {
  let mut vec: Vec<&str> = Vec::new();

  let mut i: usize = 0;
  let mut find_end = false;
  let mut a: usize = 0;
  for t in s.chars() {
    if t.is_uppercase() {
      if find_end {
        find_end = false;
        vec.push(&s[a..i + 1]);
      } else {
        find_end = true;
        a = i;
      }
    }
    i += 1;
  }
  vec
}

fn sort_str_vec(mut vec: Vec<&str>) -> Vec<&str> {
  vec.sort_by(|a, b| {
    let a_chars: Vec<char> = a.chars().collect();
    let b_chars: Vec<char> = b.chars().collect();

    let is_a_shorter = a_chars.len() < b_chars.len();
    let size = if is_a_shorter {
      a_chars.len()
    } else {
      b_chars.len()
    };

    let mut result = if is_a_shorter {
      Ordering::Less
    } else {
      Ordering::Greater
    };

    for i in 0..size {
      let cmp_result = a_chars[i].to_lowercase().cmp(b_chars[i].to_lowercase());
      if cmp_result != Ordering::Equal {
        result = cmp_result;
        break;
      }
    }
    result
  });
  vec
}

pub fn main() {
  let s = read::<String>();
  println!("{}", sort_str_vec(to_str_vec(&s)).join(""));
}

// #[test]
// fn test() {
//   main();
// }
