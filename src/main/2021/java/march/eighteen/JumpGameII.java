package march.eighteen;

public class JumpGameII {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        // dp[i]代表当前到达当前位置的最小值
        int[] dp = new int[nums.length];

        //赋初始值,每个节点的最大步数为一步一步走过去的步数
        for(int i = 0; i < dp.length; i++) dp[i] = i;

        // 可以中途跳车,所以每次都要更新跳跃过的位置的最小值
        for(int i = 0; i < nums.length - 1; i++){

            for(int j = i + 1; j <= i + nums[i]; j++){

                // 如果跳过了终点,则更新重点的值为起跳位置dp[i] + 1的值
                if(j >= nums.length - 1){

                    dp[dp.length - 1] = Math.min(dp[i] + 1, dp[dp.length - 1]);
                    break;
                }

                // 没有跳过终点，更新当前位置的最值
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {

        JumpGameII j = new JumpGameII();
        System.out.println(j.jump(new int[]{4,1,1,3,1,1,1}));
    }
}
