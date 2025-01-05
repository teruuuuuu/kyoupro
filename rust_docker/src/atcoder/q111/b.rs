use std::io;
use std::str::FromStr;

fn read_input<T: FromStr>() -> T {
    let mut input = String::new();
    io::stdin().read_line(&mut input).ok();
    input.trim().parse::<T>().ok().unwrap()
}

pub fn next_multiple_of_x(x: i16, n: i16) -> i16 {
    if n % x == 0 {
        n
    } else {
        ((n / x) + 1) * x
    }
}

fn main() {
    let input = read_input::<i16>();
    println!("{}", next_multiple_of_x(111, input));
}

#[test]
fn test() {
    main();
}