package lab1;

import java.util.Scanner;

public class Shapes {

    private static void printHollowSquare(int n) {
        if (n < 2) n = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void printDiamondOutline(int size) {
        if (size % 2 == 0) size++; // делаем нечётным для симметрии
        int mid = size / 2;
        for (int i = 0; i < size; i++) {
            int row = i <= mid ? i : size - 1 - i;
            int spaces = mid - row;
            if (row == 0) {
                System.out.println(" ".repeat(spaces) + "*");
            } else {
                int inner = 2 * row - 1;
                System.out.println(" ".repeat(spaces) + "*" + " ".repeat(inner) + "*");
            }
        }
    }

    private static void printUpArrowOutline(int shaftLen, int headWidth) {
        if (headWidth < 2) headWidth = 2;
        // Верхушка
        System.out.println(" ".repeat(headWidth - 1) + "*");
        // Контур треугольной "головки"
        for (int i = 2; i <= headWidth; i++) {
            int spaces = headWidth - i;
            int inner = 2 * i - 3;
            System.out.println(" ".repeat(spaces) + "*" + " ".repeat(inner) + "*");
        }
        // Древко (толщина 1 символ)
        for (int i = 0; i < shaftLen; i++) {
            System.out.println(" ".repeat(headWidth - 1) + "*");
        }
    }

    private static void printOvalOutline(int width, int height) {
        if (width < 6) width = 6;
        if (height < 3) height = 3;
        double a = width / 2.0;
        double b = height / 2.0;
        double eps = 0.08; // толщина линии
        for (int y = height; y >= -height; y--) {
            StringBuilder row = new StringBuilder();
            for (int x = -width; x <= width; x++) {
                double val = (x / a) * (x / a) + (y / b) * (y / b);
                if (Math.abs(val - 1.0) < eps) row.append("*");
                else row.append(" ");
            }
            System.out.println(row.toString());
        }
    }

    public static void run(Scanner sc) {
        while (true) {
            System.out.println("Фигуры из звёздочек:");
            System.out.println("1 - Квадрат (полый)");
            System.out.println("2 - Овал (контур)");
            System.out.println("3 - Стрелка ↑ (контур)");
            System.out.println("4 - Ромб (контур)");
            System.out.println("0 - Назад");
            System.out.print("Выберите (0-4): ");
            String choiceLine = sc.nextLine().trim();
            System.out.println();

            switch (choiceLine) {
                case "1" -> {
                    System.out.print("Размер квадрата n: ");
                    int n = Integer.parseInt(sc.nextLine().trim());
                    printHollowSquare(n);
                    System.out.println();
                }
                case "2" -> {
                    System.out.print("Ширина овала: ");
                    int w = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Высота овала: ");
                    int h = Integer.parseInt(sc.nextLine().trim());
                    printOvalOutline(w, h);
                    System.out.println();
                }
                case "3" -> {
                    System.out.print("Длина древка: ");
                    int shaft = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Ширина головки: ");
                    int head = Integer.parseInt(sc.nextLine().trim());
                    printUpArrowOutline(shaft, head);
                    System.out.println();
                }
                case "4" -> {
                    System.out.print("Размер ромба (нечётное лучше): ");
                    int n = Integer.parseInt(sc.nextLine().trim());
                    printDiamondOutline(n);
                    System.out.println();
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор.\n");
            }
        }
    }
}
