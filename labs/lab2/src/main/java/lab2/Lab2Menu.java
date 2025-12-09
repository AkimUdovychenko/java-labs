package lab2;

import java.util.Locale;
import java.util.Scanner;

public class Lab2Menu {

    private static final Scanner sc = new Scanner(System.in);

    private static void pressEnter() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 2 ===");
            System.out.println("1) Invoice (счёт)");
            System.out.println("2) Employee (сотрудники)");
            System.out.println("3) Date (дата)");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-3): ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1" -> { runInvoiceInteractive(); pressEnter(); }
                case "2" -> { EmployeeTest.main(null); pressEnter(); }
                case "3" -> { DateTest.main(null); pressEnter(); }
                case "0" -> { System.out.println("Выход из ЛР2..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }

    private static void runInvoiceInteractive() {
        sc.useLocale(Locale.US);
        System.out.print("Номер детали: ");
        String partNumber = sc.nextLine();

        System.out.print("Описание: ");
        String description = sc.nextLine();

        System.out.print("Количество: ");
        int quantity = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Цена за единицу: ");
        String priceStr = sc.nextLine().trim().replace(',', '.');
        double price = Double.parseDouble(priceStr);

        Invoice invoice = new Invoice(partNumber, description, quantity, price);

        System.out.println("\n--- Информация по счёту ---");
        System.out.println("Номер детали: " + invoice.getPartNumber());
        System.out.println("Описание: " + invoice.getDescription());
        System.out.println("Количество: " + invoice.getQuantity());
        System.out.println("Цена за единицу: " + invoice.getPrice());
        System.out.println("Сумма счёта: " + invoice.getInvoiceAmount());
    }
}
