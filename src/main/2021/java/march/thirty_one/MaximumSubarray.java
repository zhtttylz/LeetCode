package march.thirty_one;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        // dp[i] 表示当前位置的最大值
        int max = Integer.MIN_VALUE;

        int tmp = 0;

        for(int i = 0; i < nums.length; i++){

            if(tmp + nums[i] < nums[i]){
                tmp = nums[i];
            }else{
                tmp += nums[i];
            }

            max = Math.max(tmp, max);
        }

        return max;
    }
}
