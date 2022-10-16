use std;

pub fn answer() {
    fn read<T: std::str::FromStr>() -> T {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().ok().unwrap()
    }
    fn read_vec<T: std::str::FromStr>() -> Vec<T> {
        read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
    }

    fn vec_to_num(digit: i32, vec: &[i32]) -> i32 {
        if(vec.len() == 0) {
            0
        } else {
            digit * vec.first().unwrap() +  vec_to_num(digit * 10, &vec[1..])
        }
    }

    fn main() {
        let mut nk = read_vec::<i32>();
        nk.sort();
        let ans = nk.first().unwrap() + vec_to_num(1, &nk[1..]);;
        println!("{}", ans);
    }
    main()
}