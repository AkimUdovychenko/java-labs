package lab1;

import java.util.Scanner;

public class Lab1Menu {
    private static final Scanner SC = new Scanner(System.in);

    private static void pressEnter() {
        System.out.println();
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        try { SC.nextLine(); } catch (Exception ignored) {}
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Лабораторная работа 1 ===");
            System.out.println("1) Фигуры из звёздочек");
            System.out.println("2) Книжный магазин");
            System.out.println("3) Генератор прозвищ");
            System.out.println("4) Конвертер времени");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт (0-4): ");
            String line = SC.nextLine().trim();
            System.out.println();

            switch (line) {
                case "1" -> {
                    Shapes.run(SC);
                    pressEnter();
                }
                case "2" -> {
                    BookStore.run(SC);
                    pressEnter();
                }
                case "3" -> {
                    NicknameGenerator.run(SC);
                    pressEnter();
                }
                case "4" -> {
                    TimeConverter.run(SC);
                    pressEnter();
                }
                case "0" -> {
                    System.out.println("Выход. Пока!");
                    return;
                }
                default -> System.out.println("Неверный выбор.\n");
            }
        }
    }
}
