package December.twenty_two;

/**41. First Missing Positive
 * @author zhtttylz
 * @date 2019/12/22 21:06
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length == 0){

            return 1;
        }

        // 将数组中的每个数放到它正确的位置上
        for(int i = 0; i < nums.length; i++){

            // nums[i] 这个数，应该在nums[nums[i] - 1] 这个槽里
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++){

            if(nums[i] != (i + 1))
                return i + 1;
        }

        return nums.length + 1;
    }
}
