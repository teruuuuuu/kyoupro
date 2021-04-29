(function(f:  (input: string[]) => void, n: number){
  let input: string[] = [];
  let temp: string = "";
  process.stdin.resume();
  process.stdin.setEncoding('utf8');

  process.stdin.on('data', function(data: string) {
    temp = temp.concat(data);
    while(true){
      let index = temp.indexOf("\n");
      if(index > 0) {
        input.push(temp.substr(0, index));
        temp = temp.substr(index+1);
      } else {
        break;
      }
    }
    if(input.length == n){
      f(input);
      process.exit(0);
    }
  });
})( main, 2);

function main(input: string[]) {
  let n:number = Number(input[0]);
  let h:number[] = input[1].split(/ +/).map(x => Number(x));

  function solve(n: number, h: number[]):number {
    let dp = h.map(() => -1);;
    for (let i = 0; i < n - 1; i++) {
      if (i + 2 <= n - 1) dp[i + 2] = Math.max(0, dp[i]) + Math.abs(h[i + 2] - h[i]);
      let x = Math.max(0, dp[i]) + Math.abs(h[i + 1] - h[i]);
      if (dp[i+1] > x || dp[i+1] == -1) {
        dp[i+1] = x;
      }
    }
    return dp[n-1];
  }
  console.log(solve(n, h));
}

