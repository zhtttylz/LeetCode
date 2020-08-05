package face;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * @author zhtttylz
 * @date 2020/8/5 23:07
 * <p>
 * DFS层序进行处理 使用集合记录皇后的撇捺的数值，即行+列的值，下面的曾不会再将皇后放到该位置
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        // 分别记录已经确定皇后的列 撇 捺
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        help(0, n, pie, na, col, new ArrayList<String>(), res);

        return res;
    }

    private void help(int level, int n, Set<Integer> pie, Set<Integer> na, Set<Integer> col, ArrayList<String> strings, List<List<String>> res) {

        // 如果已经将最后一行遍历了
        if (level == n) {

            // 注意拷贝
            List<String> result = new ArrayList<>(strings);
            res.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {

            // 判断档期那位置是否在 之前皇后的同一列，撇捺
            if (col.contains(i) || pie.contains(i + level) || na.contains(i - level)) continue;

            // 开始将当前节点加入到各个集合中
            col.add(i);
            pie.add(i + level);
            na.add(i - level);
            String tmp = getString(n, i);
            strings.add(tmp);

            help(level + 1, n, pie, na, col, strings, res);

            col.remove(i);
            pie.remove(i + level);
            na.remove(i - level);

            strings.remove(tmp);
        }
    }

    private String getString(int n, int i) {

        String res = "";

        for (int j = 0; j < n; j++) {

            if (j == i) res += "Q";
            else res += ".";
        }

        return res;
    }
}
