package face;

import java.util.Arrays;

/**
 * @author zhtttylz
 * @date 2020/7/22 23:18
 * 求众数 先排序在计数 o（NlogN）
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        // 记录全局最大值
        int max = -1;
        // 记录局部最大值
        int tmp = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i+1]) {

                tmp++;
            } else {
                tmp = 1;
            }

            if(max < tmp){

                res = nums[i];
                max = tmp;
            }
        }

        return res;
    }
}
