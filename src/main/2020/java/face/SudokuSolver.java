package face;

/**
 * @author zhtttylz
 * @date 2020/8/12 22:21
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * <p>
 * A sudoku puzzle...
 * <p>
 * <p>
 * ...and its solution numbers marked in red.
 * <p>
 * Note:
 * <p>
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 * <p>
 * 将一个数独还原
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        if (board == null || board.length != 9) return;

        help(board);

    }

    /**
     * 跟判断是否是数独的原理一样，都是双重循环
     *
     * @param board
     * @return
     */
    private boolean help(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                // 说明要跳入数字
                if (board[i][j] == '.') {

                    for (char a = '1'; a <= '9'; a++) {

                        // 如果可以填入这个数
                        if (doHelp(board, a, i, j)) {
                            board[i][j] = a;
                            // 填入之后，将当前数据代入到下一层递归
                            if (help(board)) return true;

                            // 还原
                            board[i][j] = '.';
                        }
                    }

                    // 如果全部没有一个数可以填入，说明之前填写的不对，直接返回false
                    return false;
                }

            }
        }

        // 说明都填完了，直接返回true
        return true;
    }

    //矩阵判断board[i][j]能否填入char a i = 3 j = 4
    private boolean doHelp(char[][] board, char a, int i, int j) {

        for (int k = 0; k < 9; k++) {

            // 判断一行有没有重复的
            if (board[i][k] != '.' && board[i][k] == a) return false;
            // 判断一列有没有重复的
            if (board[k][j] != '.' && board[k][j] == a) return false;

            // 判断3*3的矩阵里面有没有相同的
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] != '.' &&
            board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == a) return false;
        }

        return true;
    }
}
