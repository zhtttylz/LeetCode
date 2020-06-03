package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author zhtttylz
 * @date 2020/6/4 1:11
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return new ArrayList<String>();

        // 设置字典
        String[] str = new String[]{"", "abc", "def", "ghi", "jkl"
                , "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();

        // 递归回溯
        return help(len, digits.toCharArray(), str, new ArrayList<String>(), "", 0);
    }

    /**
     *
     * @param len
     * @param c
     * @param str
     * @param res
     * @param s
     * @param index 第几个按键
     * @return
     */
    private List<String> help(int len, char[] c, String[] str, List res, String s, int index) {

        // 如果结果集的长度达到了按键个数
        if(s.length() == len) {

            res.add(s);
            return res;
        }

        // 获取对应的字典
        String zi = str[c[index] - '0' - 1];

        for(char cs : zi.toCharArray()){

            help(len, c, str, res, s + cs, index + 1);
        }

        return res;
    }
}
