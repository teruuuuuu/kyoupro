package topcoder.corporationsalary;

import org.junit.Test;

public class CorporationSalarySpec {

  @Test
  public void test1() {
    String[] relations = {"N"};
    long ans = 1;
    CorporationSalary cs = new CorporationSalary();
    long result = cs.totalSalary(relations);
    assert (ans == result);
  }

  @Test
  public void test2() {
    String[] relations = {"NNYN",
      "NNYN",
      "NNNN",
      "NYYN"};
    long ans = 5;
    CorporationSalary cs = new CorporationSalary();
    long result = cs.totalSalary(relations);
    assert (ans == result);
  }

  @Test
  public void test3() {
    String[] relations = {"NNNNNN",
      "YNYNNY",
      "YNNNNY",
      "NNNNNN",
      "YNYNNN",
      "YNNYNN"};
    long ans = 17;
    CorporationSalary cs = new CorporationSalary();
    long result = cs.totalSalary(relations);
    assert (ans == result);
  }

  @Test
  public void test4() {
    String[] relations = {"NYNNYN",
      "NNNNNN",
      "NNNNNN",
      "NNYNNN",
      "NNNNNN",
      "NNNYYN"};
    long ans = 8;
    CorporationSalary cs = new CorporationSalary();
    long result = cs.totalSalary(relations);
    assert (ans == result);
  }
}
