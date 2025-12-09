package lab5;

public class Rational {
    private int num; // числитель
    private int den; // знаменатель > 0

    public Rational() {
        this(0, 1);
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        // нормализуем знак знаменателя
        if (denominator < 0) { numerator = -numerator; denominator = -denominator; }
        int g = gcd(Math.abs(numerator), denominator);
        this.num = numerator / g;
        this.den = denominator / g;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b; b = t;
        }
        return a == 0 ? 1 : a;
    }

    public static Rational add(Rational a, Rational b) {
        return new Rational(a.num * b.den + b.num * a.den, a.den * b.den);
    }

    public static Rational sub(Rational a, Rational b) {
        return new Rational(a.num * b.den - b.num * a.den, a.den * b.den);
    }

    public static Rational mul(Rational a, Rational b) {
        return new Rational(a.num * b.num, a.den * b.den);
    }

    public static Rational div(Rational a, Rational b) {
        if (b.num == 0) throw new ArithmeticException("Division by zero");
        return new Rational(a.num * b.den, a.den * b.num);
    }

    public String toFractionString() {
        return num + "/" + den;
    }

    public String toDecimalString(int digits) {
        if (digits < 0) digits = 0;
        double v = (double) num / den;
        return String.format("%." + digits + "f", v);
    }

    @Override
    public String toString() { return toFractionString(); }
}
