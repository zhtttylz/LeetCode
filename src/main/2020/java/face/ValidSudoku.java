package face;

import top100.LetterCombinationsofaPhoneNumber;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @author zhtttylz
 * @date 2020/8/12 22:21
 * <p>
 * 判断数独板子是否有问题 判断横竖是否有重复，3*3的格子是否有重复
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // 比较每一行有没有重复的
        for (int i = 0; i < 9; i++) {

            // 行
            Map<Character, Boolean> row = new HashMap<>();

            // 列
            Map<Character, Boolean> col = new HashMap<>();

            // 3*3
            Map<Character, Boolean> help = new HashMap<>();

            for(int j = 0; j < 9; j++){

                // 判断行 从0到8
                if(board[i][j] != '.'){

                    if(row.containsKey(board[i][j])) return false;
                    row.put(board[i][j], true);
                }

                // 判断列
                if(board[j][i] != '.'){

                    if(col.containsKey(board[j][i])) return false;
                    col.put(board[j][i], true);
                }

                // 判断矩阵
                if(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.'){

                    if(help.containsKey(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) return false;
                    help.put(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3], true);
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(2 % 3);
    }
}
