use core::cmp;
use proconio::input;

fn solve(w: usize, wvl: Vec<(usize, i64)>) -> i64 {
    let mut dp = vec![0; w + 1];
    for wv in wvl {
        for v in wv.0..w + 1 {
            let vv = w - (v - wv.0);
            dp[vv] = cmp::max(dp[vv], dp[vv - (wv.0)] + wv.1);
        }
    }
    dp[w]
}

pub fn main() {
    input! {
        n: usize,
        w: usize,
        wvs: [(usize, i64);n]
    };
    println!("{}", solve(w, wvs.to_vec()))
}

// #[test]
// fn test() {
//     input! {
//         n: usize,
//         w: usize,
//         wvs: [(usize, i64);n]
//     };
//     println!("{}", solve(w, wvs.to_vec()))
// }
