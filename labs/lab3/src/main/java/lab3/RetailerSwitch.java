package lab3;

import java.util.Locale;
import java.util.Scanner;

public class RetailerSwitch {

    private static double priceOf(int item) {
        return switch (item) {
            case 1 -> 2.98;
            case 2 -> 4.50;
            case 3 -> 9.98;
            case 4 -> 4.49;
            case 5 -> 6.87;
            default -> -1.0;
        };
    }

    public static void run(Scanner sc) {
        sc.useLocale(Locale.US);

        double grandTotal = 0.0;
        int grandUnits = 0;

        System.out.println("Введите пары: <номер товара 1..5> и <кол-во>. Ноль для завершения.");
        while (true) {
            System.out.print("Номер товара (0 — конец): ");
            String sItem = sc.nextLine().trim();
            if (sItem.isEmpty()) continue;
            int item = Integer.parseInt(sItem);
            if (item == 0) break;

            double price = priceOf(item);
            if (price < 0) {
                System.out.println("  Ошибка: товара " + item + " нет. Повторите.");
                continue;
            }

            System.out.print("Количество: ");
            int qty = Integer.parseInt(sc.nextLine().trim());
            if (qty <= 0) {
                System.out.println("  Количество должно быть > 0.");
                continue;
            }

            double cost = price * qty;
            grandTotal += cost;
            grandUnits += qty;
            System.out.printf("  Товар %d по $%.2f × %d = $%.2f%n", item, price, qty, cost);
        }

        System.out.println("\nИТОГО:");
        System.out.printf("  Всего единиц: %d%n", grandUnits);
        System.out.printf("  Общая стоимость: $%.2f%n", grandTotal);
    }
}
