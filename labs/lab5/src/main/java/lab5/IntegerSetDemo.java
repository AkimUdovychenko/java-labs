package lab5;

import java.util.Scanner;

public class IntegerSetDemo {
    public static void run(Scanner sc) {
        IntegerSet s1 = new IntegerSet();
        IntegerSet s2 = new IntegerSet();

        System.out.println("Создадим два множества S1 и S2 из диапазона 0..100.");
        System.out.println("Введите элементы S1 через пробел (пустая строка — конец):");
        String line = sc.nextLine().trim();
        if (!line.isEmpty()) {
            for (String t : line.split("\\s+")) {
                try { s1.insertElement(Integer.parseInt(t)); } catch (Exception ignored) {}
            }
        }

        System.out.println("Введите элементы S2 через пробел (пустая строка — конец):");
        line = sc.nextLine().trim();
        if (!line.isEmpty()) {
            for (String t : line.split("\\s+")) {
                try { s2.insertElement(Integer.parseInt(t)); } catch (Exception ignored) {}
            }
        }

        System.out.println("\nS1 = " + s1);
        System.out.println("S2 = " + s2);

        IntegerSet u = IntegerSet.union(s1, s2);
        IntegerSet i = IntegerSet.intersection(s1, s2);

        System.out.println("S1 ∪ S2 = " + u);
        System.out.println("S1 ∩ S2 = " + i);
        System.out.println("S1 == S2 ? " + s1.isEqualTo(s2));
    }
}
