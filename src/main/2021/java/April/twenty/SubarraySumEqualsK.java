package April.twenty;

import java.util.HashMap;
import java.util.Map;

/**
 * nums中和等于k的连续字串个数
 * 使用map 记录nums[0] + nums[1] +... + nums[i]的和，如果sum -k = x存在于map中，即 k + x = sum 计算x的个数即可
 * 这里要把 初始化map[0,1] 避免sum = k为0的情况
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        // 记录sum = k时，符合条件的字符串为1
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int i =0 ; i < nums.length; i++){

            sum += nums[i];
            // 如果 x + k =sum 则k一定存在于map中，计算x的个数即可
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{9, 1, 2, 3}, 5));
    }
}
