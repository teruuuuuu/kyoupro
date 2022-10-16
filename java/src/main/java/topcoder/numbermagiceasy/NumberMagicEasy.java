package topcoder.numbermagiceasy;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=11129&rd=14237
 */
public class NumberMagicEasy {
  public int theNumbers(String answer) {
    NumberMagicEasy1 nm = new NumberMagicEasy1();
    return nm.theNumbers(answer);
  }

  class NumberMagicEasy1 {
    public int theNumbers(String answer) {
      int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
      int[] B = {1, 2, 3, 4, 9, 10, 11, 12};
      int[] C = {1, 2, 5, 6, 9, 10, 13, 14};
      int[] D = {1, 3, 5, 7, 9, 11, 13, 15};

      for (int i = 1; i <= 16; i++) {
        if (Check(A, i) != answer.charAt(0)) continue;
        if (Check(B, i) != answer.charAt(1)) continue;
        if (Check(C, i) != answer.charAt(2)) continue;
        if (Check(D, i) != answer.charAt(3)) continue;
        return i;
      }
      return 0;
    }

    char Check(int[] X, int number) {
      for (int x : X) {
        if (x == number) return 'Y';
      }
      return 'N';
    }
  }

  class NumberMagicEasy2 {
    public int theNumber(String answer) {
      String[] c = {
        "YYYYYYYYNNNNNNN",
        "YYYYNNNNYYYYNNN",
        "YYNNYYNNYYNNYYN",
        "YNYNYNYNYNYNYNY"
      };
      for (int i = 0; i <= 15; i++) {
        String temp = "";
        for (int j = 0; j < 4; j++) temp += c[j].charAt(i);
        if (answer.equals(temp)) return i + 1;
      }
      return 0;
    }
  }

}
