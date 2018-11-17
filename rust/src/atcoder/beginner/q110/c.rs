use std;

pub fn answer() {
    fn read_string() -> String {
        let mut input = String::new();
        let _ = std::io::stdin().read_line(&mut input);
        input.trim().to_string()
    }
    fn main() {
        let s = read_string();
        let t = read_string();
        let mut map1: Vec<usize> = vec![0; 26];
        let mut map2: Vec<usize> = vec![0; 26];
        for (i, j) in s.chars().zip(t.chars()) {
            let idx1 = (i as usize) - ('a' as usize);
            let idx2 = (j as usize) - ('a' as usize);
            if map1[idx1] == 0 && map2[idx2] == 0 {
                map1[idx1] = j as usize;
                map2[idx2] = i as usize;
            } else if map1[idx1] != j as usize || map2[idx2] != i as usize {
                println!("No");
                return;
            }
        }
        println!("Yes");
    }
    main()
}
