package lab4;

import java.util.Scanner;

public class Lab4Menu {
    private static final Scanner sc = new Scanner(System.in);

    private static void pause() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 4 ===");
            System.out.println("1) Угадай число (1..1000)");
            System.out.println("2) Бросок двух кубиков 36,000,000 раз");
            System.out.println("3) Система бронирования самолёта (10 мест)");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-3): ");

            String c = sc.nextLine().trim();
            System.out.println();

            switch (c) {
                case "1" -> { GuessNumber.run(sc); pause(); }
                case "2" -> { DiceStats.run(sc); pause(); }
                case "3" -> { AirlineSeating.run(sc); pause(); }
                case "0" -> { System.out.println("Выход из ЛР4..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }
}
