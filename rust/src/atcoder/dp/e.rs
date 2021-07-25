use core::cmp;
use proconio::input;

// fn solve(n: usize, w: usize, wvl: Vec<(usize, i32)>) -> Option<i32> {
//     let mut dp = vec![(w + 1) as i32; n * 1000 + 1];
//     let len = dp.len() - 1;
//     for wv in wvl {
//         for v in (wv.1 as usize)..len {
//             let vv = len - (v - wv.1 as usize);
//             dp[vv] = cmp::min(dp[vv], dp[(vv - wv.1 as usize)] + wv.0 as i32);
//         }
//         for v in 0..(wv.1 as usize) {
//             let vv = wv.1 as usize - v;
//             dp[vv] = cmp::min(dp[vv], wv.0 as i32);
//         }
//     }
//     dp.iter()
//         .enumerate()
//         .filter(|(i, v)| *v <= &(w as i32))
//         .last()
//         .map(|(i, v)| i as i32)
// }

fn solve(n: usize, w: usize, wvl: Vec<(usize, i32)>) -> Option<i32> {
    let mut dp = vec![(w + 1) as i32; n * 1000];
    let len = dp.len();
    for wv in wvl {
        let mut newDp = dp.clone();
        for v in 0..wv.1 as usize {
            newDp[v] = cmp::min(dp[v], wv.0 as i32);
        }
        for v in wv.1 as usize..len {
            newDp[v] = cmp::min(dp[v], dp[(v - wv.1 as usize)] + wv.0 as i32);
        }
        dp = newDp;
    }
    dp.iter()
        .enumerate()
        .filter(|(i, v)| *v <= &(w as i32))
        .last()
        .map(|(i, v)| (i + 1) as i32)
}

pub fn main() {
    input! {
        n: usize,
        w: usize,
        wvs: [(usize, i32);n]
    };
    match solve(n, w, wvs.to_vec()) {
        Some(v) => println!("{}", v),
        _ => println!("not found"),
    }
}

#[test]
fn test() {
    input! {
        n: usize,
        w: usize,
        wvs: [(usize, i32);n]
    };
    match solve(n, w, wvs.to_vec()) {
        Some(v) => println!("{}", v),
        _ => println!("not found"),
    }
}
