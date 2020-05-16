package top100;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 最长无重复子串
 *
 * @author zhtttylz
 * @date 2020/5/16 10:29
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;
        if (s.length() <= 1) return s.length();

        // 双指针，分别指向左右角标
        int left = 0;
        int right = 1;

        char[] chars = s.toCharArray();
        int res = -1;
        // 这里要给个初始值为1，默认最小为1
        int max = 1;
        for (; right < chars.length; right++) {


            // 判断right指向的数字在left~right-1中有咩有出现
            int index = compare(chars, left, right);

            // 说明有重复元素,需要重置max值
            if(index != -1){

                left = index + 1;
                max = right - left + 1;
            }else{

                max++;
            }

            res = Math.max(max, res);
        }

        return res;
    }

    private int compare(char[] chars, int left, int right) {

        for (int i = left; i <= right - 1; i++) {

            if (chars[i] == chars[right]) {

                return i;
            }
        }

        return -1;
    }
}
