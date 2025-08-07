public class TicTacToeBoard {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initBoard();
        placeMove(0, 0, 'X');
        placeMove(1, 1, 'X');
        placeMove(2, 2, 'X');
        printBoard();

        if (checkWin('X')) System.out.println("X wins!");
        else if (isFull()) System.out.println("Draw");
        else System.out.println("Game continues");
    }

    public static void initBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public static boolean placeMove(int row, int col, char player) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ')
            return false;
        board[row][col] = player;
        return true;
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char cell : row)
                System.out.print("|" + cell);
            System.out.println("|");
        }
    }
}
