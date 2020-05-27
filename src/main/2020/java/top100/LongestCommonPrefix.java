package top100;

import javax.xml.stream.events.StartDocument;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 求最长公共前缀 ,取第一个字符串，在整个字符串数组中比较
 * @author zhtttylz
 * @date 2020/5/27 0:25
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++){

            char a = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++){

                if(strs[j].length() <=  i || strs[j].charAt(i) != a) return str.toString();
            }
            str.append(a);
        }

        return str.toString();
    }

}
