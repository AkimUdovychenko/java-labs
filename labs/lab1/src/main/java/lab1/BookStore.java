package lab1;

import java.util.Locale;
import java.util.Scanner;

public class BookStore {
    public static void run(Scanner sc) {
        sc.useLocale(Locale.US);
        System.out.print("Цена одной книги: ");
        String priceStr = sc.nextLine().trim().replace(',', '.');
        double price = Double.parseDouble(priceStr);

        System.out.print("Количество книг: ");
        int count = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Скидка (%) : ");
        String discStr = sc.nextLine().trim().replace(',', '.');
        double discountPct = Double.parseDouble(discStr);

        double subtotal = price * count;
        double discount = subtotal * (discountPct / 100.0);
        double total = subtotal - discount;

        System.out.printf(Locale.US, "Итого к оплате: $%.2f%n", total);
        if (total > 100.0) {
            System.out.println("Бонус: Вы получаете подарочный купон!");
        }
    }

    public static void main(String[] args) {
        run(new Scanner(System.in));
    }
}
