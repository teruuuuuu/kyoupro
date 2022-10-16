use std;

struct Store {
    price: u32,
    num: u32
}
impl Store {
    pub fn new(price: u32, num: u32) -> Self {
        Store {price:price, num:num}
    }
}

pub fn main() {
    fn read<T: std::str::FromStr>() -> T {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().ok().unwrap()
    }
    fn read_vec<T: std::str::FromStr>() -> Vec<T> {
        read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
    }

    let nm = read_vec::<u32>();
    let n = nm[0];
    let m = nm[1];
    let mut a = vec![0; n as usize];
    let mut b = vec![0; n as usize];
    for i in 0..n {
      let ab = read_vec::<u32>();
      a[i as usize] = ab[0];
      b[i as usize] = ab[1];
    }
    println!("{}", answer(n, m, a, b));
}

pub fn answer(n:u32, mut m:u32, a:Vec<u32>, b:Vec<u32>) -> u64 {
  let mut ans = 0;
  let mut stores = Vec::new();
  for i in 0..n {
    stores.push(Store::new(a[i as usize], b[i as usize]))
  }
  stores.sort_by(|a, b| a.price.cmp(&b.price));
  for i in 0..n {
    let num = if stores[i as usize].num > m { m } else { stores[i as usize].num};
    ans += (stores[i as usize].price as u64) * (num as u64);
    m -= num;
    if m==0 {
      break;
    }
  }
  ans
}
