package face;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author zhtttylz
 * @date 2020/8/2 15:13
 *
 * 要时刻保证拼接字符串中左括号的个数>右括号个数
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        if(n == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        help(n, n, res, "");
        return res;
    }

    private void help(int left, int right, List<String> res, String str) {

        // 如果left和right都用完了，则之际将str添加到res中
        if(left == 0 && right == 0){

            res.add(str);
            return;
        }

        // 如果还剩余左括号，则直接填充
        if(left > 0){

            help(left - 1, right, res, str + "(");
        }

        // 如果left的个数比right的个数多
        if(right > left){


            help(left, right - 1, res, str + ")");
        }
    }
}
