package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testArea() {
    Point p1 = new Point(3, 1);
    Point p2 = new Point(7, 4);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }
}
