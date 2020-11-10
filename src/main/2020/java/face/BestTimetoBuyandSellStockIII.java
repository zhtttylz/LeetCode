package face;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Example 4:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 *
 * 买卖两次怎么能获得最多的收益 使用三维数组 dp[第n天的收益][进行了几次买卖][当前是否持有股票]
 * @author zhtttylz
 * @date 2020/11/11 0:22
 */
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length <= 1) return 0;

        // 使用三维数组 dp[第n天的收益][进行了几次买卖][当前是否持有股票]
        int[][][] dp = new int[prices.length][3][2];

        // init 没有买卖过,是否持有股票,第一天持有股票的话,收益为-price[0]
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        // init 买卖过一次,是否持有股票
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;

        //init 买卖过两次,每持有股票
        dp[0][2][0] = Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++){

            // 当天不买入,交易次数为0次,并且没有持有股票 那就是前一天的值
            dp[i][0][0] = dp[i - 1][0][0];

            // 当天买入了,交易次数0次 需要比较是今天买入收入多还是上一次买入收入多
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][0][0] - prices[i]);

            // 当前卖出了,交易次数1次,需要比较是之前买出收入高还是之前未卖出,现在卖出收入高
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);

            //当前买入了,交易次数1次,需要比较是之前买入收入高还是之前未买入,现在买入收入高
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][1][0] - prices[i]);

            // 最后卖出一次 看是之前卖出收入 还是之前未卖出,现在卖出收入高
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);

        }

        // 这里只比较没有持有股票情况
        return Math.max(dp[prices.length - 1][0][0], Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]));
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStockIII b = new BestTimetoBuyandSellStockIII();
        System.out.println(b.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
