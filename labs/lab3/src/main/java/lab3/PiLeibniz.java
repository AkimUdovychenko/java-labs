package lab3;

import java.util.Scanner;

public class PiLeibniz {

    public static void run(Scanner sc) {
        final int MAX_TERMS = 200_000;
        double sum = 0.0;
        int firstMatch = -1;

        System.out.println("k\tπ_k (Лейбниц)");
        System.out.println("-----------------------------");

        for (int k = 0; k < MAX_TERMS; k++) {
            double term = (k % 2 == 0 ? 1.0 : -1.0) / (2.0 * k + 1.0);
            sum += term;
            double approx = 4.0 * sum;

            // Печатаем таблицу каждые 10 000 и для малых k
            if (k < 20 || (k + 1) % 10_000 == 0) {
                System.out.printf("%d\t%.10f%n", (k + 1), approx);
            }

            // Первая аппроксимация, начинающаяся с 3.14159
            if (firstMatch < 0) {
                int scaled = (int)Math.floor(approx * 100_000);
                if (scaled == 314159) firstMatch = (k + 1);
            }
        }

        System.out.println("\nВычислено до " + MAX_TERMS + " членов.");
        if (firstMatch > 0) {
            System.out.println("Впервые значение, начинающееся с 3.14159, появляется на k = " + firstMatch + " членах.");
        } else {
            System.out.println("Среди первых " + MAX_TERMS + " членов значение, начинающееся с 3.14159, не достигнуто.");
        }
        System.out.println("\nЗамечание: ряд Лейбница сходится очень медленно; для высокой точности требуются миллионы членов.");
    }
}
