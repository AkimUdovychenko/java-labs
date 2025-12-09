package lab6;

// Геометрия: иерархия четырехугольников
public class Point {
    public final double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    @Override public String toString() { return "(" + x + "," + y + ")"; }
}
