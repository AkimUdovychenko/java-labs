package lab5;

import java.util.Locale;
import java.util.Scanner;

public class Lab5Menu {
    private static final Scanner sc = new Scanner(System.in);

    private static void pause() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        while (true) {
            System.out.println("=== Лабораторная работа 5 ===");
            System.out.println("1) IntegerSet (множества 0..100)");
            System.out.println("2) Rational (арифметика дробей)");
            System.out.println("3) TicTacToe (крестики-нолики 3x3)");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-3): ");

            String c = sc.nextLine().trim();
            System.out.println();

            switch (c) {
                case "1" -> { IntegerSetDemo.run(sc); pause(); }
                case "2" -> { RationalDemo.run(sc); pause(); }
                case "3" -> { TicTacToeDemo.run(sc); pause(); }
                case "0" -> { System.out.println("Выход из ЛР5..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }
}
