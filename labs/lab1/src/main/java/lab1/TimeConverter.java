package lab1;

import java.util.Scanner;

public class TimeConverter {
    public static String recommendation(int minutes) {
        if (minutes < 120) return "Неплохо, но можно ещё поработать";
        if (minutes <= 300) return "Хороший рабочий день";
        return "Сделай перерыв, хватит кодить!";
    }

    public static void run(Scanner sc) {
        System.out.print("Сколько минут вы провели за компьютером? ");
        int minutes = Integer.parseInt(sc.nextLine().trim());

        int days = minutes / (60 * 24);
        int hours = (minutes % (60 * 24)) / 60;
        int mins = minutes % 60;

        System.out.printf("%d минут = %d дн %d ч %d мин%n", minutes, days, hours, mins);
        System.out.println("Рекомендация: " + recommendation(minutes));
    }

    public static void main(String[] args) {
        run(new Scanner(System.in));
    }
}
