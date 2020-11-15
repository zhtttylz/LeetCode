package face;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * dp 求解 dp[i] 当i块钱时最少需要多少硬币
 * @author zhtttylz
 * @date 2020/11/16 1:08
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(amount == 0 || coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        // init dp
        dp[0] = 0;
        for(int j = 0; j < coins.length; j++){

            if(coins[j] <= amount) dp[coins[j]] = 1;
        }

        for(int i = 1; i <= amount; i++){

            int minTmp = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){

                // 如果初始化过了 直接变为0 在最下面+ 1
                if(coins[j] == i){

                    minTmp = 0;
                    break;
                }

                // 避免越界,如果未0 说明没有硬币可以组成这个数,不对这一位进行比窘
                if((i - coins[j] >= 0) && (dp[i - coins[j]] != -1)){

                    minTmp = Math.min(minTmp, dp[i - coins[j]]) ;
                }
            }

            // 如果组不成,直接返回-1
            dp[i] = Integer.MAX_VALUE == minTmp ? -1 : minTmp + 1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{2}, 3));
    }
}
