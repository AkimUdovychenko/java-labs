package lab4;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void run(Scanner sc) {
        Random rnd = new Random();
        while (true) {
            int target = 1 + rnd.nextInt(1000);
            System.out.println("Угадайте число от 1 до 1000.");
            int tries = 0;
            while (true) {
                System.out.print("Ваша догадка: ");
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                int guess;
                try {
                    guess = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Введите целое число.");
                    continue;
                }
                tries++;
                if (guess == target) {
                    System.out.println("Поздравляем! Вы угадали число за " + tries + " попыток!");
                    break;
                } else if (guess > target) {
                    System.out.println("Слишком большое. Попробуйте снова.");
                } else {
                    System.out.println("Слишком маленькое. Попробуйте снова.");
                }
            }
            System.out.print("\nСыграть ещё раз? (y/n): ");
            String again = sc.nextLine().trim().toLowerCase();
            System.out.println();
            if (!again.equals("y") && !again.equals("д") && !again.equals("yes")) break;
        }
    }
}
