package lab4;

import java.util.Scanner;

public class AirlineSeating {

    public static void run(Scanner sc) {
        boolean[] seats = new boolean[10]; // 0..9 -> места 1..10
        int assigned = 0;

        while (assigned < 10) {
            System.out.println("Пожалуйста, введите 1 для бизнес-класса (1-5)");
            System.out.println("Пожалуйста, введите 2 для эконом-класса (6-10)");
            System.out.print("Ваш выбор (1/2, q - выход): ");
            String line = sc.nextLine().trim().toLowerCase();
            if (line.equals("q")) {
                System.out.println("Завершение работы...");
                return;
            }
            if (!line.equals("1") && !line.equals("2")) {
                System.out.println("Неверный ввод.\n");
                continue;
            }
            boolean business = line.equals("1");
            int seat = assignSeat(seats, business ? 0 : 5, business ? 5 : 10);
            if (seat >= 0) {
                assigned++;
                System.out.println("Ваше место: " + (seat + 1) + (business ? " (бизнес)" : " (эконом)"));
                printMap(seats);
                System.out.println();
            } else {
                // выбранная секция полна — предложить альтернативу
                boolean otherBusiness = !business;
                int otherSeat = assignSeat(seats, otherBusiness ? 0 : 5, otherBusiness ? 5 : 10);
                if (otherSeat >= 0) {
                    System.out.print((business ? "Бизнес" : "Эконом") + " заполнен. Согласны на " + (otherBusiness ? "бизнес" : "эконом") + "? (y/n): ");
                    String ans = sc.nextLine().trim().toLowerCase();
                    if (ans.equals("y") || ans.equals("д")) {
                        assigned++;
                        System.out.println("Ваше место: " + (otherSeat + 1) + (otherBusiness ? " (бизнес)" : " (эконом)"));
                        printMap(seats);
                        System.out.println();
                    } else {
                        System.out.println("Следующий рейс отправляется через 3 часа.\n");
                    }
                } else {
                    System.out.println("Все места заняты. Следующий рейс отправляется через 3 часа.");
                    return;
                }
            }
        }
        System.out.println("Самолёт полностью заполнен. Программа завершена.");
    }

    private static int assignSeat(boolean[] seats, int from, int to) {
        for (int i = from; i < to; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i;
            }
        }
        return -1;
    }

    private static void printMap(boolean[] seats) {
        System.out.print("Схема мест: ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i == 5 ? " | " : " "));
            System.out.print((i + 1) + (seats[i] ? "[X]" : "[ ]"));
        }
        System.out.println();
    }
}
