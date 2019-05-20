package ru.stqa.pft.sanbox;

public class Point {
  public double y;
  public double x;

  public Point(double y, double x) {
    this.y = y;
    this.x = x;
  }

  public double area() {
    return this.y * this.x;
  }
}
