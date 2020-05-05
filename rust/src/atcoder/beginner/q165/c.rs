use std::cmp::max;
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

#[derive(Clone, Debug)]
struct Calculator {
  q: usize,
  a: Vec<usize>,
  b: Vec<usize>,
  c: Vec<i32>,
  d: Vec<i32>,
}

impl Calculator {
  fn new(q: usize, a: Vec<usize>, b: Vec<usize>, c: Vec<i32>, d: Vec<i32>) -> Self {
    Self {
      q: q,
      a: a,
      b: b,
      c: c,
      d: d,
    }
  }

  fn exec(self, array: &[i32]) -> i32 {
    let mut ans: i32 = 0;
    for i in 0..self.q {
      if array[self.b[i as usize] - 1] - array[self.a[i as usize] - 1] == self.c[i as usize] {
        ans += self.d[i as usize];
        // println!(
        //   "exec add[{:?}] d[{:?}] ans[{:?}]",
        //   i, self.d[i as usize], ans
        // );
      }
    }
    ans
  }
}

#[test]
fn comp() {
  main();
}

fn main() {
  let s = stdin();
  let mut s = s.lock();
  let s = &mut s;
  let n = read::<i32>(s).unwrap();
  let m = read::<usize>(s).unwrap();
  let q = read::<usize>(s).unwrap();

  let mut a: Vec<usize> = Vec::with_capacity(q);
  let mut b: Vec<usize> = Vec::with_capacity(q);
  let mut c: Vec<i32> = Vec::with_capacity(q);
  let mut d: Vec<i32> = Vec::with_capacity(q);

  for _ in 0..q {
    a.push(read::<usize>(s).unwrap());
    b.push(read::<usize>(s).unwrap());
    c.push(read::<i32>(s).unwrap());
    d.push(read::<i32>(s).unwrap());
  }
  let calculator = Calculator::new(q, a, b, c, d);

  // println!("calculator={:?}", calculator);

  fn dfs(rest: i32, start: i32, end: i32, calculator: Calculator, vec: &mut Vec<i32>) -> i32 {
    // println!("rest={:?} start={:?} end={:?}", rest, start, end);
    if rest >= 1 {
      let mut ans = 0;
      for i in start..=end {
        vec.push(i);
        ans = max(ans, dfs(rest - 1, i, end, calculator.clone(), vec));
        vec.pop();
      }
      ans
    } else {
      // println!("array={:?}", vec);
      calculator.exec(&vec)
    }
  }

  println!(
    "{:?}",
    dfs(
      n,
      1,
      m as i32,
      calculator,
      &mut Vec::with_capacity(n as usize)
    )
  );
}

#[test]
fn test() {
  main();
}
