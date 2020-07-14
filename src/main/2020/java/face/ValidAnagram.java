package face;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author zhtttylz
 * @date 2020/7/15 0:44
 * 求两个只包含小写字母的字符串中所有字母出现的次数是否相等
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s == null || t == null || s.length() != t.length()) return false;

        int[] res = new int[26];
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        for(char c : chars) res[c - 'a'] += 1;

        for(char c : chars1) res[c- 'a'] -= 1;

        for(int i = 0; i < res.length; i++){

            if(res[i] != 0) return false;
        }

        return true;
    }
}
