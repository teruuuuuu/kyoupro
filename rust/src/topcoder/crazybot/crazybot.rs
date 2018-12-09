use std;

pub fn answer() {

    struct direction {
        x: i32,
        y: i32,
        prob: f32
    }

    struct crazy_bot {
        grid: [[i32; 100]; 100],
        dir: [direction; 4]
    }

    impl crazy_bot {
        fn update(&mut self, x: usize, y: usize, num: i32) {
            self.grid[x as usize][y as usize] = num;
        }
    }

    fn makeCb(east: i32, weast: i32, south: i32, north: i32) -> crazy_bot {
        let dir1 = direction{x: 1, y:0, prob: east as f32/100.0};
        let dir2 = direction{x: -1, y:0, prob: weast as f32/100.0};
        let dir3 = direction{x: 0, y:1, prob: south as f32/100.0};
        let dir4 = direction{x: 0, y:-1, prob: north as f32/100.0};

        let mut grid = [[0; 100]; 100];
        let mut dir = [dir1, dir2, dir3, dir4];
        let mut ret = crazy_bot{grid: grid, dir: dir};
        return ret
    }

    fn solve(cb: &mut crazy_bot, n: i32, x:i32, y:i32) -> f32 {
        if(cb.grid[x as usize][y as usize] == 1){
            0.0
        } else if(n == 0) {
            1.0
        } else {

            let mut ret: f32 = 0.0;
            cb.update(x as usize, y as usize, 1);
            let mut i = 0;
            while(i < 4){
                let k = x+cb.dir[i].x;
                let l = y+cb.dir[i].y;
                ret += solve(cb, n-1, k, l) * cb.dir[i].prob;
                i = i + 1
            }
            cb.update(x as usize, y as usize, 0);
            ret
        }

    }

    fn read<T: std::str::FromStr>() -> T {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().ok().unwrap()
    }

    fn main() {
        let n = read::<i32>();
        let east = read::<i32>();
        let west = read::<i32>();
        let south = read::<i32>();
        let north = read::<i32>();

        let mut cb = &mut makeCb(east, west, south, north);
        println!("{}", solve(cb, n, 50, 50))
    }
    main()
}