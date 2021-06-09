package June.nine;

/**
 * 找寻两个数组中最长的相同字串
 * 暴力被排除，提示超时
 * dp[i][j] 表示以nums1[i]nums2[j]结尾并且nums1[i]和nums2[j]相等的最长子数组的长度
 * 得到递推式 if(nums1[i] == nums2[j]) dp[i][j] = dp[i - 1][j - 1] + 1  : 0
 * 原因是: nums1[i] != nums2[j] 说明不存在以这两个数为结尾的子数组,返回0 如果相等,则判断前一位是否相等,在前一位的基础+1
 */
public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2.length == 0) return 0;

        int res = 0;
        // dp[i][j] 表示以nums1[i]nums2[j]相等的最长子数组的长度
        // 得到递推式 if(nums1[i] == nums2[j]) dp[i][j] = dp[i - 1][j - 1] + 1  : 0
        // 原因是: nums1[i] != nums2[j] 说明不存在以这两个数为结尾的子数组,返回0 如果相等,则判断前一位是否相等,在前一位的基础+1
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for(int i = 1; i <= nums1.length; i++){

            for(int j = 1; j <= nums2.length; j++){

                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{

                    dp[i][j] = 0;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
