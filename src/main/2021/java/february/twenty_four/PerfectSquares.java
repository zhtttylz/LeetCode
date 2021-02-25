package february.twenty_four;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        if (n == 0 || n == 1) return 1;
        // dp[i]代表保存的最小的由完全平方数组成的个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        // 从0开始，记录每个数自己相乘的数值
        for (int i = 0; i <= n; i++) {

            // 将每个j*j +i的数求出来，跟新dp[i +j*j的值]
            for (int j = 1; i + j * j <= n; j++) {

                // 看是原先的值大,还是当前的dp[i] + 1*1更少
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
