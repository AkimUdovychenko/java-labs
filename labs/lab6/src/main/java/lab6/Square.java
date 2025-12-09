package lab6;

public class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1,p2,p3,p4);
    }
    public static Square byLeftTop(double x, double y, double side) {
        return new Square(new Point(x,y),
                          new Point(x+side,y),
                          new Point(x+side,y-side),
                          new Point(x,y-side));
    }
    @Override public double area() { return super.area(); }
}
