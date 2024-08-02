public class Sudoku {
    private static final int BOARD_SIZE = 9;

    static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------");
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                }
                    System.out.print(board[i][j]);

            }
            System.out.println();
        }
    }

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board,number,column)&&
                !isNumberInBox(board,number,row,column);
    }


    static boolean canSolve(int[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= BOARD_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if(canSolve(board)){
                                return true;
                            }else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}
