package November.twenty_one;

/**
 * @author zhtttylz
 * @date 2019/11/21 23:56
 * 找寻无序数组中缺少的最小正整数
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length == 0){

            return 0;
        }

        // 决定采用内存换时间的做法，使用一个最大长度的数组，将nums中所有的数放到里面，找寻最小的数
        int[] res = new int[Integer.MAX_VALUE];
        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0){

                res[i] = nums[i];
            }
        }

        // 找到数组中某一位为0的情况
        for(int i = 1; i < res.length; i++){

            if(nums[i] == 0){

                return i;
            }
        }

        return 0;
    }
}
