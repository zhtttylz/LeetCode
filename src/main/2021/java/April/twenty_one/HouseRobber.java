package April.twenty_one;

import sun.nio.cs.ext.MacHebrew;
import top100.LetterCombinationsofaPhoneNumber;

import java.util.Map;

public class HouseRobber {

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        if(nums.length < 2) return nums[0];

        int[] dp = new int[nums.length];

        // init dp 只给第一位和第二位赋值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);

        for(int i = 2; i < nums.length; i++){

            // 当前位置最大值取决当前位置偷还是不偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(new int[]{2, 1, 1, 2}));
    }
}
