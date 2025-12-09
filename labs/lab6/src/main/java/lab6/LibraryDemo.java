package lab6;

import java.util.Scanner;

public class LibraryDemo {
    public static void run(Scanner sc) {
        Library lib = new Library();
        // книги
        lib.addBook(new Book("Clean Code", "R. Martin"));
        lib.addBook(new Book("Effective Java", "J. Bloch"));
        lib.addBook(new Book("Design Patterns", "GoF"));
        // пользователи
        lib.registerUser(new User("Akim"));
        lib.registerUser(new User("Nazar"));

        System.out.println("Демонстрация библиотеки с исключениями.\nКоманды:");
        System.out.println(" lend <bookTitle> <userName>");
        System.out.println(" return <bookTitle> <userName>");
        System.out.println(" show");
        System.out.println(" exit\n");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (line.equalsIgnoreCase("show")) { lib.printState(); continue; }

            String[] parts = line.split("\\s+", 3);
            if (parts.length < 3) { System.out.println("Неверная команда."); continue; }

            String cmd = parts[0].toLowerCase();
            String book = parts[1];
            String user = parts[2];

            try {
                switch (cmd) {
                    case "lend" -> { lib.lendBook(book, user); System.out.println("Выдано: " + book + " -> " + user); }
                    case "return" -> { lib.returnBook(book, user); System.out.println("Возвращено: " + book + " <- " + user); }
                    default -> System.out.println("Неизвестная команда");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        System.out.println("Завершено.");
    }
}
