package June.twenty_three;

/**
 * 给一个target 求其最少能由数组中几个数组成
 * 思路:求个数,使用dp
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(coins == null || amount == 0) return 0;

        // dp[i] 表示i这个数最少由coins中的几个硬币组成
        int[] dp = new int[amount + 1];

        // init dp
        for(int i = 1; i < dp.length; i++){

            // 硬币最小为1 dp每一位都初始化为不可能的硬币个数,即amount+1个硬币
            // 主要是为了防止amount无法由硬币组成
            dp[i] = amount + 1;
        }

        dp[0] = 0;
        for(int i = 1; i <= amount; i++){

            for(int j = 0; j < coins.length; j++){

                // 小心dp数组越界,i-coins[j] >= 0时,再进行计算
                if(i >= coins[j]){

                    // dp[i] 判断是之前的dp[i]小还是+当前的值小
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }


        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
