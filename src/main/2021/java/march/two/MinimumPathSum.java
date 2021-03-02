package march.two;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        //create dp dp[i][j]为当前的最小和
        int[][] dp = new int[grid.length][grid[0].length];
        //init dp
        dp[0][0] = grid[0][0];
        for(int i = 1; i < dp.length; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for(int i = 1; i < dp[0].length; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        // 计算每个块的最小值
        for(int i = 1; i < dp.length; i++){

            for(int j = 1; j < dp[0].length; j++){

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
