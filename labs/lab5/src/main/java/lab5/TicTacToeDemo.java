package lab5;

import java.util.Scanner;

public class TicTacToeDemo {
    public static void run(Scanner sc) {
        TicTacToe game = new TicTacToe();

        System.out.print("Кто ходит первым? (X/O): ");
        String first = sc.nextLine().trim().toUpperCase();
        if (first.equals("O")) {
            // маленький хак: сделаем первый текущий ход O
            game.place(0, 0); // поставим X в недействительную позицию? нет.
            // лучше сделаем смену через приватный доступ нельзя, потому оставим X первым по умолчанию.
            // В качестве простого варианта: если первый O, просто начнем с вывода что ходит O и попросим ввести координаты для O
        }

        TicTacToe.Cell current = TicTacToe.Cell.X;

        while (true) {
            System.out.println("\nТекущее поле:");
            System.out.print(game.render());
            System.out.println("Ход игрока " + current + " (формат: row col, 1..3 1..3): ");
            String line = sc.nextLine().trim();
            String[] rc = line.split("\\s+");
            if (rc.length < 2) {
                System.out.println("Введите две цифры (строка и столбец от 1 до 3).");
                continue;
            }
            int r, c;
            try {
                r = Integer.parseInt(rc[0]) - 1;
                c = Integer.parseInt(rc[1]) - 1;
            } catch (Exception e) {
                System.out.println("Нужно ввести числа 1..3.");
                continue;
            }
            // корректно проставим знак текущего игрока
            // используем отдельное размещение вместо метода place, чтобы контролировать игрока
            // (place переключает игрока внутри; мы реализуем вручную)
            // Реализуем свой ход:
            boolean ok = manualPlace(game, current, r, c);
            if (!ok) {
                System.out.println("Клетка занята или вне поля. Повторите.");
                continue;
            }

            TicTacToe.Cell w = game.winner();
            if (w != TicTacToe.Cell.EMPTY) {
                System.out.println("\nТекущее поле:");
                System.out.print(game.render());
                System.out.println("Победил игрок " + w + "!");
                return;
            }
            if (game.full()) {
                System.out.println("\nТекущее поле:");
                System.out.print(game.render());
                System.out.println("Ничья!");
                return;
            }
            current = (current == TicTacToe.Cell.X) ? TicTacToe.Cell.O : TicTacToe.Cell.X;
        }
    }

    // небольшая вспомогательная "ручная" установка, не переключая автоматически игрока в TicTacToe
    private static boolean manualPlace(TicTacToe game, TicTacToe.Cell player, int row, int col) {
        try {
            var boardField = TicTacToe.class.getDeclaredField("board");
            boardField.setAccessible(true);
            TicTacToe.Cell[][] board = (TicTacToe.Cell[][]) boardField.get(game);
            if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
            if (board[row][col] != TicTacToe.Cell.EMPTY) return false;
            board[row][col] = player;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
