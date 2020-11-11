package face;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * 最长上升子序列，双重循环，第一重遍历所有数，第二重遍历从0到i - 1的最长上子序列 当前位置的
 * 最长上升子序列就是之前的最长上升子序列 + 1
 * @author zhtttylz
 * @date 2020/11/12 1:13
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        // create init dp
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){

            int tmp = 0;
            for(int j = 0; j < i; j++){

                if(nums[i] > nums[j]) tmp = Math.max(dp[j], tmp);

            }
            dp[i] = tmp + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
