package bak.无重复字符的最长子串;

/**
 * 使用字典的方式进行处理
 * 这里提出一个假设：如果允许重复一次呢
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        char[] c = s.toCharArray();

        // 每个元素最多允许出现的次数
        int k = 1;

        // ASCII 只有256个
        int[] dictionary = new int[256];

        // 左指针
        int left = 0;

        int res = 0;

        for(int i = 0; i < c.length; i++){

            // 说明当前数组中已经重复了k次，做指针需要移动
            if(dictionary[c[i]] == k){

                // 当需要移动左指针的时候，需要计算更新一次res的值
                res = Math.max(res, i - left);
                dictionary[c[left]]--;
                left++;
                i--;
            }else{

                dictionary[c[i]]++;
            }

        }

        // 最后要比较一下left和数组有边界组成的无重复字串的长度
        return Math.max(res, s.length() - left);
    }
}
