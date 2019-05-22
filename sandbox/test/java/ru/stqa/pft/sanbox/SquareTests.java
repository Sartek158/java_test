package ru.stqa.pft.sanbox;

import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void TestArea() {
    Square s = new Square(5);
    assert  s.area() == 25;
  }
}
