package November.eight;

import java.util.Arrays;

/**16. 3Sum Closest
 * 找寻数组中三个数组成的结果最接近target的结果，并将其返回
 * 跟3sum一样,就是计算差值的绝对值,这里对多余的计算进行优化
 * @author zhtttylz
 * @date 2019/11/9 21:36
 */
public class Solution1 {

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

                int tempSum = nums[i] + nums[left] + nums[right];
                if(target > tempSum){
                    // 先算出目标数和当前加和的绝对值
                    int abs = Math.abs(target - tempSum);
                    // 更新差值,并更新最终结果
                    if(abs < diff){

                        diff = abs;
                        res = tempSum;
                    }

                    left ++;
                }else if (target < tempSum){

                    int abs = Math.abs(target - tempSum);
                    if(abs < diff){

                        diff = abs;
                        res = tempSum;
                    }
                    right--;
                }else{

                    return target;
                }
            }
        }

        return res;
    }
}
