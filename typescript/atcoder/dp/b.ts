((main:  (input: string[]) => void, n: number) => {
  const input: string[] = [];

  const reader = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });

  reader.on('line', (line: string) => {
    input.push(line);
    if(input.length >= n) {
      main(input);
      process.exit(0);
    }
  });
})( main, 2);

export function main(input: string[]) {
  const [n,k] = input[0].split(/ +/).map(x => Number(x));
  const h = input[1].split(/ +/).map(x => Number(x));
  const dp: number[] = h.map(() => -1);
  dp[0] = 0;

  for(let i = 0; i < n; i++ ) {
    for(let j = 1; j <= k && (i+j) < n; j++ ) {
      const next = dp[i] + Math.abs(h[i+j] - h[i]);
      dp[i+j] = (dp[i+j] === -1 || dp[i+j] > next) ? next : dp[i+j];
    }
  }
  console.log(dp[n - 1]);
}

