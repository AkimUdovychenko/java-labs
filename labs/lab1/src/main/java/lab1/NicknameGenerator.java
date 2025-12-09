package lab1;

import java.util.Scanner;

public class NicknameGenerator {
    public static void run(Scanner sc) {
        System.out.print("Ваше имя(На английском): ");
        String name = sc.nextLine().trim();
        System.out.print("Ваш возраст: ");
        int age = Integer.parseInt(sc.nextLine().trim());

        String suffix;
        if (age < 18) suffix = "Junior";
        else if (age <= 40) suffix = "Pro";
        else suffix = "Boss";

        String nickname = name + " " + suffix;
        System.out.println("Ваше прозвище: " + nickname);
    }

    public static void main(String[] args) {
        run(new Scanner(System.in));
    }
}
