package atcoder.beginner.Tenka2019;

import java.util.Scanner;

public class TenkaB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();
    int k = sc.nextInt();
    char c = s.charAt(k-1);
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++ ){
      if(s.charAt(i) == c) {
        sb.append(c);
      } else {
        sb.append('*');
      }
    }
    System.out.println(sb.toString());
  }
}
