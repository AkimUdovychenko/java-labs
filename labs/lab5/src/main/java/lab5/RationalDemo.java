package lab5;

import java.util.Locale;
import java.util.Scanner;

public class RationalDemo {
    public static void run(Scanner sc) {
        sc.useLocale(Locale.US);
        System.out.println("Введите две дроби a/b и c/d (например: 2/3 5/6):");
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");
        Rational r1 = parse(parts.length > 0 ? parts[0] : "0/1");
        Rational r2 = parse(parts.length > 1 ? parts[1] : "0/1");

        Rational sum = Rational.add(r1, r2);
        Rational dif = Rational.sub(r1, r2);
        Rational prod = Rational.mul(r1, r2);
        Rational quot = Rational.div(r1, r2);

        System.out.println("a = " + r1 + ", b = " + r2);
        System.out.println("a + b = " + sum + " = " + sum.toDecimalString(6));
        System.out.println("a - b = " + dif + " = " + dif.toDecimalString(6));
        System.out.println("a * b = " + prod + " = " + prod.toDecimalString(6));
        System.out.println("a / b = " + quot + " = " + quot.toDecimalString(6));
    }

    private static Rational parse(String s) {
        String[] ab = s.split("/");
        int a = Integer.parseInt(ab[0]);
        int b = (ab.length > 1) ? Integer.parseInt(ab[1]) : 1;
        return new Rational(a, b);
    }
}
