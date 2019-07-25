package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Ivan");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Reactangle r = new Reactangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(3, 1);
    Point p2 = new Point(7, 4);
    System.out.println("Расстояние между точками " + p1.x + ";" + p1.y + " и " + p2.x + ";" + p2.y + " = " + p1.distance(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Reactangle r) {
    return r.a * r.b;
  }

}