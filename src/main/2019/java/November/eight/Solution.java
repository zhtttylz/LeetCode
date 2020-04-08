package November.eight;

import java.util.Arrays;

/**16. 3Sum Closest
 * 找寻数组中三个数组成的结果最接近target的结果，并将其返回
 * @author zhtttylz
 * @date 2019/11/9 21:36
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length == 0){

            return 0;
        }
        int res = 0;
        int diff = Integer.MAX_VALUE;
        // 判断两个数之间的差值，使用绝对值，math.abs
        Arrays.sort(nums);

        // 因为内部遍历了两个数,所以i这层只遍历到后两层
        for(int i = 0; i < nums.length - 2; i++){

            // 设置左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){

                if(nums[left] + nums[right] + nums[i] > target){ // 应该将右指针左移

                    int tempTar = nums[left] + nums[right] + nums[i];

                    if(Math.abs(target - tempTar) < diff){

                        diff = Math.abs(target - tempTar);
                        res = nums[left] + nums[right] + nums[i];
                    }
                    right--;

                }else{
                    // 计算当前的三个数的和的绝对值
                    int tempTar = nums[left] + nums[right] + nums[i];

                    if(Math.abs(target - tempTar) < diff){

                        diff = Math.abs(target - tempTar);
                        res = nums[left] + nums[right] + nums[i];
                    }
                    // 左指针右移
                    left++;
                }
            }
        }

        return res;
    }
}
