use std::cmp::max;
use std::collections::HashMap;
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

fn sort_by_value(map: &HashMap<i32, usize>) -> Vec<(i32, usize)> {
    let mut vec: Vec<(i32, usize)> = map.iter().map(|(&k, &v)| (k, v)).collect();
    vec.sort_by(|a, b| b.1.cmp(&a.1)); // 値で降順にソート
    vec
}

fn count_even_odd_indices(vec: &Vec<i32>) -> (Vec<(i32, usize)>, Vec<(i32, usize)>) {
    let mut even_counts = HashMap::new();
    let mut odd_counts = HashMap::new();

    for (i, &value) in vec.iter().enumerate() {
        if i % 2 == 0 {
            *even_counts.entry(value).or_insert(0) += 1;
        } else {
            *odd_counts.entry(value).or_insert(0) += 1;
        }
    }

    (sort_by_value(&even_counts), sort_by_value(&odd_counts))
}

fn solve(count1: &[(i32, usize)], count2: &[(i32, usize)]) -> usize {
    if count1.len() == 0 && count2.len() == 0 {
        0
    } else if count1.len() == 0 {
        count2[0].1
    } else if count2.len() == 0 {
        count1[0].1
    } else {
        let (count1_head, count1_tail) = match count1 {
            [head, tail @ ..] => (head, tail),
            [] => panic!(""),
        };
        let (count2_head, count2_tail) = match count2 {
            [head, tail @ ..] => (head, tail),
            [] => panic!(""),
        };
        if count1_head.0 != count2_head.0 {
            count1_head.1 + count2_head.1
        } else {
            max(solve(count1, count2_tail), solve(count1_tail, count2))
        }
    }
}

fn main() {
    let n = read_input::<usize>();
    let inputs = read_vec::<i32>();
    let (count1, count2) = count_even_odd_indices(&inputs);
    println!("{}", n - solve(&count1, &count2));
}
