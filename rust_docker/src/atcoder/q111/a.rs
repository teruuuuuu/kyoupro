use std::io;

fn read_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).ok();
    input.trim().to_string()
}

pub fn swap_1_and_9(input: &str) -> String {
    input.chars()
        .map(|c| match c {
            '1' => '9',
            '9' => '1',
            _ => c,
        })
        .collect()
}

fn main() {
    let input = read_input();
    println!("{}", swap_1_and_9(&input));
}

#[test]
fn test() {
    main();
}