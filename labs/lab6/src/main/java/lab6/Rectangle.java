package lab6;

public class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1,p2,p3,p4);
    }
    public static Rectangle axisAligned(double x, double y, double width, double height) {
        return new Rectangle(new Point(x,y),
                             new Point(x+width,y),
                             new Point(x+width,y-height),
                             new Point(x,y-height));
    }
    @Override public double area() { return polygonArea(); }
}
