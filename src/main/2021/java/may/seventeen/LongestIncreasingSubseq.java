package may.seventeen;

/**
 * 最长上升子序列 不需要连续
 */
public class LongestIncreasingSubseq {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        // dp[i] 代表到当前位置的最长递增子序列
        int[] dp = new int[nums.length];

        // init
        dp[0] = 1;
        int res = 1;

        for(int i = 1; i < nums.length; i++){

            //init
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }

            res = Math.max(res, dp[i]);

        }
        return res;
    }
}
