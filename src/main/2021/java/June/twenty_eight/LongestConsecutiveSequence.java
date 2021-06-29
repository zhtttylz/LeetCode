package June.twenty_eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 求出给定数组中可以组成的最大连续序列
 * 序列在nums中不要求连续，但是最终要可以组成连续的字串
 * 求字符串长度，使用dp 动态规划
 * 要求o(n)的时间复杂度
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int res = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {

            // 如果map中有了当前数的长度引用,则不进行计算,一因为其他位置的数已经执行完了映射
            if(map.containsKey(num)) continue;

            // 获取当前数的左右映射长度
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int cur = left + right + 1;
            res = Math.max(cur, res);

            // 更新当前数的能到达的位置的引用值
            map.put(num + right, cur);
            map.put(num - left, cur);
            map.put(num, cur);
        }

        return res;
    }
}
