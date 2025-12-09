package lab5;

public class TicTacToe {
    public enum Cell { X, O, EMPTY }
    private final Cell[][] board = new Cell[3][3];
    private Cell current = Cell.X;

    public TicTacToe() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = Cell.EMPTY;
    }

    public boolean place(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
        if (board[row][col] != Cell.EMPTY) return false;
        board[row][col] = current;
        current = (current == Cell.X) ? Cell.O : Cell.X;
        return true;
    }

    public Cell winner() {
        // строки/столбцы
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Cell.EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return board[i][0];
            if (board[0][i] != Cell.EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return board[0][i];
        }
        // диагонали
        if (board[0][0] != Cell.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if (board[0][2] != Cell.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
        return Cell.EMPTY;
    }

    public boolean full() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == Cell.EMPTY) return false;
        return true;
    }

    public Cell currentPlayer() { return current; }

    public String render() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = switch (board[i][j]) {
                    case X -> 'X';
                    case O -> 'O';
                    default -> ' ';
                };
                sb.append(' ').append(c).append(' ');
                if (j < 2) sb.append('|');
            }
            sb.append('\n');
            if (i < 2) sb.append("---+---+---\n");
        }
        return sb.toString();
    }
}
