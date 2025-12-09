package lab6;

import java.util.Scanner;

public class Lab6Menu {
    private static final Scanner sc = new Scanner(System.in);

    private static void pause() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 6 ===");
            System.out.println("1) Иерархия четырехугольников (площади)");
            System.out.println("2) CarbonFootprint (полиморфизм)");
            System.out.println("3) Библиотека с собственными исключениями");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-3): ");
            String c = sc.nextLine().trim();
            System.out.println();
            switch (c) {
                case "1" -> { QuadDemo.run(); pause(); }
                case "2" -> { CarbonDemo.run(); pause(); }
                case "3" -> { LibraryDemo.run(sc); pause(); }
                case "0" -> { System.out.println("Выход из ЛР6..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }
}
