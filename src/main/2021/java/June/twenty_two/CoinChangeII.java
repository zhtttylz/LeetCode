package June.twenty_two;

/**
 * 求amount 可以由coin中元素组成的个数
 * 求个数,使用dp
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {

        if(amount < 0 || coins.length == 0) return 0;

        // dp[i][j] 代表 i 可以由coins组成的个数
        int[] dp = new int[amount + 1];

        // init dp
        dp[0] = 1;

        // 这里要求的是每个数值可以组成的方式，不是由多少个硬币组成，所以要使用硬币匹配每个数
        for(int i = 0; i < coins.length; i++){

            // 计算每一位可以被硬币组成的可能
            for(int j = coins[i]; j <= amount; j++){

                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII c = new CoinChangeII();
        System.out.println(c.change(5, new int[]{1, 2, 5}));
    }
}
