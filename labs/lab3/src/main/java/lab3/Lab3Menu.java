package lab3;

import java.util.Scanner;

public class Lab3Menu {
    private static final Scanner sc = new Scanner(System.in);

    private static void pause() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 3 ===");
            System.out.println("1) Факториалы 1..20 (long) + вопрос про 100!");
            System.out.println("2) Онлайн-ритейлер (switch + sentinel)");
            System.out.println("3) Ряд Лейбница для π (до 200000 членов)");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-3): ");
            String c = sc.nextLine().trim();
            System.out.println();

            switch (c) {
                case "1" -> { FactorialTable.run(sc); pause(); }
                case "2" -> { RetailerSwitch.run(sc); pause(); }
                case "3" -> { PiLeibniz.run(sc); pause(); }
                case "0" -> { System.out.println("Выход из ЛР3..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }
}
