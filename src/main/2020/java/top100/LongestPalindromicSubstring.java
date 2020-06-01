package top100;

import java.util.logging.Level;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * 求最长的回文子串
 * 1.回文子串的求法 最简单的方法就是暴力，直接穷举所有的可能（n3 超时）
 * 。动态规划，如果dp[i+1][j-1]是回文 && s[i] == s[j] 则dp[i][j]就是回文
 * Input: "cbbd"
 * Output: "bb"
 * @author zhtttylz
 * @date 2020/5/22 22:30
 */
public class LongestPalindromicSubstring {

    /**
     * 递归方式进行求解
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if(s == null || s.length() <= 1) return s;

        // dp[i][j] == 1 代表从字符串i到j是回文
        int[][] dp = new int[s.length()][s.length()];

        char[] chars = s.toCharArray();
        // 回文子串右指针
        int right = 0;
        // 记录字符串中开始位置,和num一起用进行切割
        int start = 0;
        //初始化dp
        for(int i = 0; i < chars.length; i++){

            // 初始化
            dp[i][i] = 1;

            if((i < chars.length - 1) && chars[i] == chars[i + 1]){
                dp[i][i + 1] = 1;
                start = i;
                right = i + 1;
            }
        }

        // 外层遍历字符串长度
        for(int len = 2 ; len < chars.length; len++){

            // 枚举所有字串长度,最后小心越界
            for(int j = 0; j < chars.length - len; j ++){

                int tail = j + len;

                //如果dp[i+1][j-1]是回文 && s[i] == s[j] 则dp[i][j]就是回文
                if(chars[j] == chars[tail] && dp[j + 1][tail - 1] == 1){

                    start = j;
                    right = tail;
                    dp[j][tail] = 1;
                }
            }
        }

        return s.substring(start, right + 1);
    }

    public String longestPalindrome01(String s) {

        if(s == null || s.length() <= 1) return s;

        String res = "";

        for(int i = 0; i < s.length(); i++){

            for(int j = i + 1; j <= s.length(); j++){

                String substring = s.substring(i, j);

                if(help(substring)){

                    res = res.length() > substring.length() ? res : substring;
                }
            }
        }

        return res;
    }

    /**
     * 判断是否是一个回文
     * @param substring
     * @return
     */
    private boolean help(String substring) {

        int left = 0;
        int right = substring.length() - 1;
        char[] c = substring.toCharArray();
        while(left < right){

            if(c[left++] != c[right--]) return false;
        }

        return true;
    }
}
