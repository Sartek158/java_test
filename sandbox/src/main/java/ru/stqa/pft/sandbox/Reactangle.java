package ru.stqa.pft.sandbox;

public class Reactangle {
  public double a;
  public double b;

  public Reactangle(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double area() {
    return this.a * this.b;
  }
}
