package face;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhtttylz
 * @date 2020/8/9 12:42
 * N皇后，只需要返回N皇后的数量即可，还是使用n皇后的办法，直接返回集合数量
 */
public class NQueensII {

    public int totalNQueens(int n) {

        if(n <= 1) return n;

        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        help(0, n, pie, na, col, res, new ArrayList<String>());

        return res.size();
    }

    private void help(int level, int n, Set<Integer> pie, Set<Integer> na, Set<Integer> col, List<List<String>> res, ArrayList<String> tmp) {

        if(level == n){

            res.add(new ArrayList<String>(tmp));
            return;
        }

        for(int i = 0; i < n; i++){

            if(col.contains(i) || pie.contains(i + level) || na.contains(i - level)) continue;

            col.add(i);
            pie.add(i + level);
            na.add(i - level);

            String str = getStr(n, i);
            tmp.add(str);

            help(level + 1, n, pie, na, col, res, tmp);

            col.remove(i);
            pie.remove(i + level);
            na.remove(i - level);
            tmp.remove(str);
        }
    }

    private String getStr(int n, int i) {

        String str = "";

        for(int j = 0; j < n; j++){

            if(i == j) str += "Q";
                    else str += ".";
        }

        return str;
    }
}
