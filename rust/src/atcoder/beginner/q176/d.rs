use std;

use std::collections::VecDeque;

pub fn main() {
  fn read_line() -> String {
    let mut buf = String::new();
    std::io::stdin().read_line(&mut buf);
    buf
  }
  fn read_tuple() -> (i32, i32) {
    let a: Vec<usize> = read_line()
      .split_whitespace()
      .map(|e| e.parse().unwrap())
      .collect();
    (a[0] as i32, a[1] as i32)
  }
  let (h, w) = read_tuple();
  let (ch, cw) = read_tuple();
  let (dh, dw) = read_tuple();

  let mut map: Vec<Vec<i32>> = Vec::new();
  for _ in 0..h {
    let mut row: Vec<i32> = Vec::new();
    let s: Vec<char> = read_line().trim().chars().collect();
    for j in 0..w {
      if s[j as usize] == '.' {
        row.push(-1);
      } else {
        row.push(-2);
      }
    }
    map.push(row);
  }

  let mv: Vec<(i32, i32)> = {
    let mut v = Vec::new();
    for i in -2..3 {
      for j in -2..3 {
        if !(i == 0 && j == 0) {
          v.push((i, j));
        }
      }
    }
    v
  };

  let mut deque: VecDeque<(i32, i32, i32)> = VecDeque::new();
  deque.push_front((ch, cw, 0));

  while !deque.is_empty() {
    let (cur_h, cur_w, point) = deque.pop_front().unwrap();
    if map[(cur_h as usize) - 1][(cur_w as usize) - 1] != -1 {
      continue;
    }
    map[(cur_h as usize) - 1][(cur_w as usize) - 1] = point;
    if cur_h == dh && cur_w == dw {
      println!("{}", point);
      return;
    }

    for next in &mv {
      let next_h = cur_h + next.0;
      let next_w = cur_w + next.1;
      if (next_h >= 1)
        && (next_w >= 1)
        && next_h <= h
        && next_w <= w
        && map[next_h as usize - 1][next_w as usize - 1] == -1
      {
        if next.0.abs() + next.1.abs() == 1 {
          deque.push_front((next_h, next_w, point));
        } else {
          deque.push_back((next_h, next_w, point + 1));
        }
      }
    }
  }
  println!("-1");
  return;
}

// pub fn main() {
//   struct Maze {
//     h: usize,
//     w: usize,
//     mv: Vec<(i32, i32)>,
//     warp: Vec<(i32, i32)>,
//     map: Vec<Vec<i32>>,
//   }
//   impl Maze {
//     fn new(h: usize, w: usize, map: Vec<Vec<i32>>) -> Self {
//       let mv: Vec<(i32, i32)> = vec![(-1, 0), (1, 0), (0, -1), (0, 1)];
//       let warp: Vec<(i32, i32)> = {
//         let mut v = Vec::new();
//         for i in -2..3 {
//           for j in -2..3 {
//             if !(i == 0 && j == 0)
//               && !(i == -1 && j == 0)
//               && !(i == 1 && j == 0)
//               && !(i == 0 && j == -1)
//               && !(i == 0 && j == 1)
//             {
//               v.push((i, j));
//             }
//           }
//         }
//         v
//       };

//       Self {
//         h,
//         w,
//         mv,
//         warp,
//         map,
//       }
//     }
//     fn mark(&mut self, h: i32, w: i32, point: i32) -> bool {
//       if h <= 0 || w <= 0 || h > self.h as i32 || w > self.w as i32 {
//         false
//       } else {
//         let val = self.map[(h - 1) as usize][(w - 1) as usize];
//         if val == -1 || val > point {
//           self.map[(h - 1) as usize][(w - 1) as usize] = point;
//           true
//         } else {
//           false
//         }
//       }
//     }
//     fn mv(&mut self, start_h: usize, start_w: usize) {
//       let mut next_vec = VecDeque::new();
//       next_vec.push_front((start_h, start_w));
//       loop {
//         if next_vec.len() == 0 {
//           break;
//         } else {
//           let next = next_vec.pop_front().unwrap();
//           let mv_point = self.map[next.0 - 1][next.1 - 1];
//           for x in &self.mv.clone() {
//             let next_h = next.0 as i32 + x.0;
//             let next_w = next.1 as i32 + x.1;
//             if self.mark(next_h, next_w, mv_point) {
//               next_vec.push_back((next_h as usize, next_w as usize));
//             }
//           }
//         }
//       }
//     }
//     fn warp(&mut self, point: i32) -> VecDeque<(usize, usize)> {
//       let mut v = VecDeque::new();
//       for i in 1..self.h + 1 {
//         for j in 1..self.w + 1 {
//           if self.map[i - 1][j - 1] == -1 {
//             let mut p = -1;
//             for x in &self.warp.clone() {
//               let next_h = (*x).0 + i as i32;
//               let next_w = (*x).1 + j as i32;
//               if next_h >= 1 && next_w >= 1 && next_h <= self.h as i32 && next_w <= self.w as i32 {
//                 let val = self.map[next_h as usize - 1][next_w as usize - 1];
//                 if val >= 0 && (p == -1 || val < p) {
//                   p = val;
//                 }
//               }
//             }
//             if p >= 0 {
//               v.push_back((i, j));
//             }
//           }
//         }
//       }
//       for x in &v {
//         self.map[(*x).0 - 1 as usize][(*x).1 - 1 as usize] = point;
//       }
//       v
//     }
//     fn solve(&mut self, start_h: usize, start_w: usize) {
//       self.map[start_h - 1][start_w - 1] = 0;
//       let mut next_vec = VecDeque::new();
//       next_vec.push_front((start_h, start_w));
//       let mut point = 0;
//       loop {
//         if next_vec.len() == 0 {
//           break;
//         } else {
//           for x in &next_vec {
//             self.mv((*x).0, (*x).1);
//           }
//           point += 1;
//           next_vec = self.warp(point);
//         }
//       }
//     }
//     fn print(&self) {
//       for row in &self.map {
//         println!(
//           "{}",
//           row.into_iter().fold(String::new(), |acc, cur| acc
//             + &*if *cur == -1 {
//               String::from(".")
//             } else if *cur == -2 {
//               String::from("#")
//             } else {
//               cur.to_string()
//             })
//         );
//       }
//     }
//   }
//   fn read_line() -> String {
//     let mut buf = String::new();
//     std::io::stdin().read_line(&mut buf);
//     buf
//   }
//   fn read_tuple() -> (usize, usize) {
//     let a: Vec<usize> = read_line()
//       .split_whitespace()
//       .map(|e| e.parse().unwrap())
//       .collect();
//     (a[0], a[1])
//   }
//   let (h, w) = read_tuple();
//   let (ch, cw) = read_tuple();
//   let (dh, dw) = read_tuple();
//   let mut map: Vec<Vec<i32>> = Vec::new();
//   for _ in 0..h {
//     let mut row: Vec<i32> = Vec::new();
//     let s: Vec<char> = read_line().trim().chars().collect();
//     for j in 0..w {
//       if s[j] == '.' {
//         row.push(-1);
//       } else {
//         row.push(-2);
//       }
//     }
//     map.push(row);
//   }
//   let mut maze = Maze::new(h, w, map);
//   maze.solve(ch, cw);
//   // maze.print();
//   println!("{}", maze.map[dh - 1 as usize][dw - 1 as usize]);
//   // maze.print();
// }

// use proconio::{input, fastout};
//     use proconio::marker::{Chars, Isize1};
//     use std::collections::{HashSet, VecDeque};

//     #[fastout]
//     fn main() {
//         input! {
//             h: isize,
//             w: isize,
//             start: (Isize1, Isize1),
//             goal: (Isize1, Isize1),
//             s: [Chars; h as usize]
//         }

//         let mut seen: HashSet<(isize, isize)> = HashSet::new();
//         let mut deq: VecDeque<(isize, isize, isize)> = VecDeque::new();
//         deq.push_back((start.1, start.0, 0));

//         while !deq.is_empty() {
//             let (x, y, point) = deq.pop_front().unwrap();
//             if x == goal.1 && y == goal.0 {
//                 println!("{}", point);
//                 return
//             }
//             if seen.contains(&(x, y)) { continue }
//             seen.insert((x, y));

//             for r in -2..=2isize {
//                 for c in -2..=2isize {
//                     if r == 0 && c == 0 { continue }

//                     let nx = x + c;
//                     let ny = y + r;
//                     if nx < 0 || w <= nx || ny < 0 || h <= ny { continue }
//                     if s[ny as usize][nx as usize] != '.' { continue }
//                     if seen.contains(&(nx, ny)) { continue }
//                     if r.abs() + c.abs() == 1 {
//                         deq.push_front((nx, ny, point));
//                     }else{
//                         deq.push_back((nx, ny, point + 1));
//                     }
//                 }
//             }
//         }

//         println!("-1");
//     }
