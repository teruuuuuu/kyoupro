use std;

fn main() {
 fn read<T: std::str::FromStr>() -> T {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().ok().unwrap()
    }
    fn read_vec<T: std::str::FromStr>() -> Vec<T> {
        read::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
    }
    fn main() {
        let HW = read_vec::<i32>();
        let hw = read_vec::<i32>();
        println!("{}", (HW[0]-hw[0])*(HW[1]-hw[1]));
    }
    let HW = read_vec::<i32>();
    let hw = read_vec::<i32>();
    answer(HW, hw);
}

pub fn answer(HW:Vec<i32>, hw:Vec<i32>) {
    println!("{}", (HW[0]-hw[0])*(HW[1]-hw[1]));
}
