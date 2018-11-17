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

    fn primes(max:i64) -> Vec<i64>{
        let mut k = vec![2,3];
        for c in (1..(max/6)+1){
            let a = c*6-1;
            let b = c*6+1;
            let mut af = true;
            let mut bf = true;
            for d in (0..k.len()) {
                if(af && (a % k[d]) == 0){
                    af = false;
                }
                if(bf && (b % k[d]) == 0){
                    bf = false;
                }
            }
            if(af){
                k.append(&mut vec![a])
            }
            if(bf){
                k.append(&mut vec![b])
            }
        }
        return k
    }
    fn invmod(p:i64, g:i64) -> i64 {
        fn euclidean(px:i64, py:i64, pgcd:i64, x:i64, y:i64, gcd:i64) -> i64 {
            match (pgcd % gcd) {
                0 => x,
                _ => {
                    let d = pgcd /gcd;
                    let m = pgcd % gcd;
                    return euclidean(x, y, gcd, px-(d*x), py-(d*y), m)
                }
            }
        }
        return (euclidean(1,0,p,0,1,g)+g)%g;
    }
    fn multiper(n:i64, m:i64, c:i64) -> (i64, i64) {
        match m % n {
            0 => multiper(n, m/n, c+1),
            _ => (m,c)
        }
    }

    fn comb(n:i64, k:i64, p:i64)-> i64 {
        let mut ans = 1;
        for c in (1..k+1){
            ans = remain(multi(ans , (n-c+1)), p);
            ans = remain(multi(ans, invmod(c, p)), p);
//            ans = remain(divide(ans , c), p);
        }
        return ans
    }

    fn fac(l:Vec<i64>, m:i64) -> Vec<i64> {
        match l.len() {
            0 => vec![1],
            _ => {
                let mut ll = l;
                let a = match multiper(ll.pop().unwrap(), m, 0) {
                    (1, 0) => vec![],
                    (1, y) => vec![y],
                    (x, 0) => {
                        return fac(ll, m)
                    }
                    (x, y) => {
                        let mut k = vec![y];
                        k.append(&mut fac(ll,x));
                        return k
                    }
                };
                return a;
            }
        }
    }

    fn multi(a:i64, b:i64) -> i64 {a*b}
    fn divide(a:i64, b:i64) -> i64 {a/b}
    fn remain(a:i64, b:i64) -> i64 {a%b}
    fn main() {
        let max = 1000000007;
        let mut nk = read_vec::<i64>();
        let n:i64 = nk[0];
        let m:i64 = nk[1];
        let primes = primes(((m as f64).sqrt() as i64));

        let f = fac(primes, m);
        let mut a = 1;
        for c in f {
            a = remain(multi(a,comb(n+c-1, c, max)),max)
        }
        println!("{}", a);
    }
    main()
}