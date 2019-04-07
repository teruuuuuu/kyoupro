package topcoder.circlescountry;

import org.junit.Test;

public class CirclesCountrySpec {

  @Test
  public void test() {
    int X[] = {-107, -38, 140, 148, -198, 172, -179, 148, 176, 153, -56, -187};
    int Y[] = {175, -115, 23, -2, -49, -151, -52, 42, 0, 68, 109, -174};
    int R[] = {135, 42, 70, 39, 89, 39, 43, 150, 10, 120, 16, 8};
    int x1 = 102;
    int y1 = 16;
    int x2 = 19;
    int y2 = 108;
    int ans = 3;
    CirclesCountry cc = new CirclesCountry();
    int result = cc.leastBorders(X, Y, R, x1, y1, x2, y2);
    assert(ans == result);
  }
}
