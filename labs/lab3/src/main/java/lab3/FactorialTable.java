package lab3;

import java.util.Scanner;

public class FactorialTable {

    // вычисляет n! в long; для n>20 произойдет переполнение
    private static long factLong(int n) {
        long r = 1L;
        for (int i = 2; i <= n; i++) r *= i;
        return r;
    }

    public static void run(Scanner sc) {
        System.out.println("n\t n! (long)");
        System.out.println("---------------------");
        for (int n = 1; n <= 20; n++) {
            System.out.printf("%d\t %d%n", n, factLong(n));
        }
        System.out.println("\nВопрос: \"Какая сложность может помешать вычислить 100!?\"");
        System.out.println("- При использовании типа long произойдет переполнение уже после 20!, ");
        System.out.println("  т.к. 21! > Long.MAX_VALUE. Для 100! нужен BigInteger.");
        System.out.println("- По трудоёмкости алгоритм O(n), т.е. требуется ~100 умножений, что не проблема;");
        System.out.println("  ограничение именно в диапазоне типа данных, а не во времени.");
    }
}
