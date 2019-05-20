package ru.stqa.pft.sanbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Ivan");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Reactangle r = new Reactangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Reactangle r) {
    return r.a * r.b;
  }
}