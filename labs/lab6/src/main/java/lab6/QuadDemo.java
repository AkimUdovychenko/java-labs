package lab6;

public class QuadDemo {
    public static void run() {
        System.out.println("Демонстрация площадей четырехугольников\n");

        Trapezoid t = new Trapezoid(
                new Point(0,0), new Point(6,0), new Point(4,-3), new Point(1,-3));
        Parallelogram p = new Parallelogram(
                new Point(0,0), new Point(5,0), new Point(7,-3), new Point(2,-3));
        Rectangle r = Rectangle.axisAligned(0, 5, 4, 3); // ширина 4, высота 3
        Square s = Square.byLeftTop(0, 4, 2.5);

        System.out.printf("Trapezoid area = %.3f%n", t.area());
        System.out.printf("Parallelogram area = %.3f%n", p.area());
        System.out.printf("Rectangle area = %.3f%n", r.area());
        System.out.printf("Square area = %.3f%n", s.area());
    }
}
