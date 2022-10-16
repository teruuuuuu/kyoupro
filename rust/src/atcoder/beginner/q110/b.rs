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
    fn take(vec: &[i32], i: i32) -> i32 {
        match vec.get(i as usize) {
            Some(x) => *x,
            None => 0
        }
    }
    fn min_array(mut vec: Vec<i32>) -> i32 {
        vec.sort();
        let a= vec.first().unwrap();
        return *a;
    }
    fn max_array(mut vec: Vec<i32>) -> i32 {
        vec.sort();
        vec.reverse();
        let a = vec.first().unwrap();
        return *a;
    }

    fn main() {
        let vec = read_vec::<i32>();
        let num_x = take(&vec, 0);
        let num_y = take(&vec, 1);
        let x = take(&vec, 2);
        let y = take(&vec, 3);
        let xs = max_array(read_vec::<i32>());
        let ys = min_array(read_vec::<i32>());
        let x_p = if x < xs  {xs} else {x};
        let y_p = if y > ys  {ys} else {y};
        if x_p >= y_p {
            println!("War");
        } else {
            println!("No War");
        }
    }
    main()
}