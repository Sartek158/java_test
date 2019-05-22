package ru.stqa.pft.sanbox;

public class Point {
  public double y;
  public double x;

  public Point(double y, double x) {
    this.y = y;
    this.x = x;
  }

  public double distance(Point p2) {
    return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
  }
}
