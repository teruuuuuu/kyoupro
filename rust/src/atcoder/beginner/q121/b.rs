use std;

pub fn main() {
    fn read<T: std::str::FromStr>() -> T {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().ok().unwrap()
    }
    fn read_vec<T: std::str::FromStr>() -> Vec<T> {
        read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
    }

    let nmc = read_vec::<i32>();
    let n = nmc[0];
    let m = nmc[1];
    let c = nmc[2];
    let b = read_vec::<i32>();
    let mut a = Vec::new();
    for i in 0..n {
      a.push(read_vec::<i32>());
    }
    println!("{}", answer(n,m,c,b,a));
}

pub fn answer(n:i32, m:i32, c:i32, b:Vec<i32>, a:Vec<Vec<i32>>) -> i64 {
    let mut ans = 0;
    for i in 0..n {
      let mut sum = c;
      for j in 0..m {
        sum += b[j as usize]*a[i as usize][j as usize]
      }
      if sum > 0 {
        ans += 1;
      }
    }
    ans
}
