package march.nine;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ||
                obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i = 0; i < obstacleGrid.length; i++){

            if(obstacleGrid[i][0] == 1) {
                while (i < obstacleGrid.length) dp[i++][0] = 0;
                break;
            }

            dp[i][0] = 1;
        }

        for(int i = 0; i < obstacleGrid[0].length; i++){

            if(obstacleGrid[0][i] == 1) {
                while (i < obstacleGrid[0].length) dp[0][i++] = 0;
                break;
            }

            dp[0][i] = 1;
        }

        for(int i = 1; i < obstacleGrid.length; i++){

            for(int j = 1; j < obstacleGrid[0].length; j++){

                if(obstacleGrid[i][j] != 1)
                    dp[i][j] =dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
