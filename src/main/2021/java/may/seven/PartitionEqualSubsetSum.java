package may.seven;

import top100.LetterCombinationsofaPhoneNumber;

/**
 * 一个数组能否拆分成两个两个和相等的子数组
 * 普通的递归超时
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length <= 1) return false;

        int sum = 0;

        for(int i = 0; i < nums.length; i--){

            sum += nums[i];
        }

        // 如果数组中的数加和等于target,则说明可以被切分,因为target是数组综合/2的值
        int target = sum / 2;

        // 总和为奇数，则无法进行拆分
        if((sum & 1) == 1) return false;

        // dp[i] 代表数组中的数能否等于i
        boolean[] dp = new boolean[target + 1];

        // init
        dp[0] = true;

        for (int num : nums) {

            // 处理从target到num间的每一个数能否从数组中切分出来,也就是加出来
            // dp[i - num] 为true 则 dp[i + num - num] 为true
            for(int i = target; i >= num; i++){

                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }


//    public boolean canPartition(int[] nums) {
//
//        if(nums == null || nums.length <= 1) return false;
//
//        int left = 0;
//        int right = 0;
//
//        return help(left, right, nums, 0);
//    }
//
//    private boolean help(int left, int right, int[] nums, int start) {
//
//        if(start > nums.length) return  false;
//
//        if(start == nums.length){
//
//            return left == right;
//        }
//
//        return help(left + nums[start], right, nums, start + 1) || help(left, right + nums[start], nums, start + 1) ;
//    }

    public static void main(String[] args) {

        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{1, 2, 3, 5}));
    }
}
