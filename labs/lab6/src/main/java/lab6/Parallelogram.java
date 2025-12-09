package lab6;

public class Parallelogram extends Trapezoid {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1,p2,p3,p4);
    }
    @Override public double area() { return polygonArea(); }
}
