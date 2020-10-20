package face;

import com.sun.javafx.webkit.CursorManagerImpl;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * @author zhtttylz
 * @date 2020/10/21 1:08
 * 记录局部最大值和局部最小值,全局最大值用来记录可能遇到的整数还有负负得正 全局最小值用来记录负负得正之前的最小值
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int res = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for(int i = 1; i < nums.length; i++){

            // 分别计算当前位的最大最小值
            int tmpMax = curMax * nums[i];
            int tmpMin = curMin * nums[i];

            // 计算当前最大值，如果nums[i]是负数,则当前的局部最大值位负数,直到遇到另一个负数,或者是遇到一个正数
            curMax = Math.max(tmpMax, Math.max(tmpMin, nums[i]));
            curMin = Math.min(tmpMax, Math.min(tmpMin, nums[i]));

            // 更新全局最大值
            res = Math.max(res, curMax);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray s = new MaximumProductSubarray();
        s.maxProduct(new int[]{-1,-2,-9,-6});
    }
}
