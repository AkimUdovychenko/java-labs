package lab4;

import java.util.Random;
import java.util.Scanner;

public class DiceStats {

    public static void run(Scanner sc) {
        final int ROLLS = 36_000_000;
        System.out.println("Будет выполнено " + ROLLS + " бросков двух кубиков...");
        int[] counts = new int[13]; // индексы 2..12
        Random rnd = new Random();

        for (int i = 0; i < ROLLS; i++) {
            int d1 = 1 + rnd.nextInt(6);
            int d2 = 1 + rnd.nextInt(6);
            counts[d1 + d2]++;
        }

        System.out.println("\nСумма\tЧастота\t\tДоля");
        System.out.println("-------------------------------");
        for (int s = 2; s <= 12; s++) {
            double p = counts[s] / (double) ROLLS;
            System.out.printf("%2d\t%,10d\t%1.5f%n", s, counts[s], p);
        }
        System.out.println("\nОжидаемое распределение: 7 чаще всего; 2 и 12 — реже всего.");
    }
}
