package march.sixteen;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        // 使用dp dp[i]代表到达当前位置所需要的所有的可能
        int[][] dp = new int[m][n];

        // init dp 第一行第一列的可能次数为1
        for(int i = 0; i < m; i++){

            dp[i][0] = 1;
        }

        for(int i = 0; i < n; i++){

            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){

            for(int j = 1; j < n; j++){

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
