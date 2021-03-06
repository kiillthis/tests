package leetcode.surroundedRegions;

/**
 * @author Andrii Kompaniiets
 * @version 1.0
 * Look javadoc for {@link SurroundRegionsConverter#findBoardWithoutSurroundedRegions(char[][])}
 */
public class SurroundRegionsConverter {

    /**
     * Method to find surrounded 'O' and change them to 'X'
     *
     * @param board two-dimensional char array with 'O' and 'X'
     * @return if board has not any row, it would returned back;
     * if board is null, new empty array will be returned.
     * Otherwise, board will be processed and
     * the method will return new two-dimensional char array with replaced surrounded 'O' to 'X'
     */
    public char[][] findBoardWithoutSurroundedRegions(char[][] board) {
        if(board == null) {
            return new char[0][0];
        }
        if (board.length == 0) {
            return board;
        }
        if (board[0].length == 0) {
            return board;
        }
        char[][] newBoard = board.clone();
        for (int i = 0; i < newBoard[0].length; i++) {
            if (newBoard[0][i] == 'O')
                markAllCirclesAsGrid(newBoard, 0, i);
            if (newBoard[newBoard.length - 1][i] == 'O')
                markAllCirclesAsGrid(newBoard, newBoard.length - 1, i);
        }
        for (int i = 0; i < newBoard.length; i++) {
            if (newBoard[i][0] == 'O')
                markAllCirclesAsGrid(newBoard, i, 0);
            if (newBoard[i][newBoard[0].length - 1] == 'O')
                markAllCirclesAsGrid(newBoard, i, newBoard[0].length - 1);
        }
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                if (newBoard[i][j] == '#')
                    newBoard[i][j] = 'O';
                else if (newBoard[i][j] == 'O')
                    newBoard[i][j] = 'X';
            }
        }
        return newBoard;
    }

    /**
     * Method that marks all 'O' to '#' using depth-first search
     * @param board two-dimensional char array with 'X', 'O' or '#'
     * @param i row of array
     * @param j column of array
     */
    private void markAllCirclesAsGrid(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        markAllCirclesAsGrid(board, i + 1, j);
        markAllCirclesAsGrid(board, i - 1, j);
        markAllCirclesAsGrid(board, i, j + 1);
        markAllCirclesAsGrid(board, i, j - 1);
    }
}
