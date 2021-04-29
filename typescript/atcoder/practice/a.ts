// process.stdin.resume();
// process.stdin.setEncoding('utf8');

// let i = 0;
// let a:number = 0;

// const inputs = (line: String) => {
//   if(i == 0) {
//     a += Number(line);
//   } else if(i == 1) {
//     a += line.split(/ +/).reduce((acc:number, cur: String):number => acc + Number(cur), 0);
//   } else if(i == 2){
//     console.log(String(a) + " " + line);
//     process.exit(0);
//   }
//   i++;
// }

// process.stdin.on('data', function(data: String) {
//   let lines = data.split(/\r\n|\r|\n/).map(x => x.trim()).filter(x => x.length > 0);
//   lines.forEach(inputs);
// });
