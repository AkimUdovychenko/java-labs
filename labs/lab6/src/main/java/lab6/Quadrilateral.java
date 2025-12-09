package lab6;

public class Quadrilateral {
    // приватные вершины
    private final Point p1, p2, p3, p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
    }

    protected Point[] points() { return new Point[]{p1,p2,p3,p4}; }

    // Общая площадь произвольного многоугольника (формула Гаусса, "шнурок")
    protected double polygonArea() {
        Point[] p = points();
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            Point a = p[i];
            Point b = p[(i+1) % 4];
            sum += a.x * b.y - b.x * a.y;
        }
        return Math.abs(sum) / 2.0;
    }

    @Override public String toString() {
        Point[] p = points();
        return "Q" + java.util.Arrays.toString(p);
    }
}
