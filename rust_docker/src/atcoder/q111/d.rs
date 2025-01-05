use std::collections::HashSet;
use std::io;
use std::str::FromStr;

fn read_input<T: FromStr>() -> T {
    let mut input = String::new();
    io::stdin().read_line(&mut input).ok();
    input.trim().parse::<T>().ok().unwrap()
}

fn read_vec<T: std::str::FromStr>() -> Vec<T> {
    read_input::<String>().split_whitespace().map(|e| e.parse().ok().unwrap()).collect()
}

fn read_n_pair<T>(n: usize) -> Vec<(T, T)> 
where T: Copy + std::str::FromStr
{
    (0..n).map(|_| {
        let vec = read_vec::<T>();
        let (first, second) = match vec.as_slice() {
            [first, second] => (first, second),
            _ => unreachable!(),
        };
        (*first, *second)

    }).collect::<Vec<(T, T)>>()
} 

fn to_mods(input: &Vec<(i32, i32)>) -> HashSet<i32> {
    input.iter()
        .map(|(a, b)| (a + b).abs() % 2)
        .collect()
}

fn vec_to_str(vec: &Vec<i32>) -> String {
    vec.iter().map(|x| x.to_string()).collect::<Vec<String>>().join(" ")
}

fn arm_operation(vec: &mut Vec<char>, x: i32, y: i32) {
    let xpy = x + y;
    let xmy = x - y;
    let xpy_binary = (xpy as i64 + (1 << 31) - 1) / 2;
    let xmy_binary = (xmy as i64 + (1 << 31) - 1) / 2;
    
    for i in 0..31 {
        if xpy_binary & (1 << i) != 0 && xmy_binary & (1 << i) != 0 {
            vec[i] = 'R';
        } else if xpy_binary & (1 << i) != 0 && xmy_binary & (1 << i) == 0 {
            vec[i] = 'U';
        } else if xpy_binary & (1 << i) == 0 && xmy_binary & (1 << i) != 0 {
            vec[i] = 'D';
        } else {
            vec[i] = 'L';
        }
    }

}

fn main() {
    let n = read_input::<usize>();
    let input: Vec<(i32, i32)> = read_n_pair(n);
    let mods: HashSet<i32> = to_mods(&input);
    let mut vec: Vec<char> = Vec::with_capacity(31);
    vec.resize(31, ' ');

    if mods.len() != 1 {
        println!("-1");
    } else if mods.contains(&1) {
        println!("31");
        println!("{}", vec_to_str(&(0..31).map(|i| 1 << i).collect::<Vec<i32>>()));
        for (x, y) in input {
            arm_operation(&mut vec, x, y);
            println!("{}", vec.iter().collect::<String>());
        }
        

    } else {
        println!("32");
        println!("{} {}", 1, vec_to_str(&(0..31).map(|i| 1 << i).collect::<Vec<i32>>()));

        for (x, y) in input {
            arm_operation(&mut vec, x-1, y);
            println!("{}{}", 'R', vec.iter().collect::<String>());
        }
    }
}
