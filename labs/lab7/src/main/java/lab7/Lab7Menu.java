package lab7;

import java.util.Scanner;

public class Lab7Menu {
    private static final Scanner sc = new Scanner(System.in);

    private static void pause() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 7 ===");
            System.out.println("1) Stream API: пользователи и операции");
            System.out.println("2) Generics: универсальное хранилище Storage<T>");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-2): ");
            String c = sc.nextLine().trim();
            System.out.println();

            switch (c) {
                case "1" -> { UsersStreamDemo.run(); pause(); }
                case "2" -> { StorageDemo.run(); pause(); }
                case "0" -> { System.out.println("Выход из ЛР7..."); return; }
                default -> System.out.println("Неверный выбор!\n");
            }
        }
    }
}
