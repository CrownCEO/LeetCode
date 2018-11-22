package Array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).  Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * @author Mr.Bao
 * @create 2018-10-23-21:09
 * @since 1.0.0
 */
public class No63UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1?0:1;

        for(int i = 1;i<n;i++){
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
            }else{
                dp[0][i] = dp[0][i - 1];
            }
        }

        for(int j = 1;j<m;j++){
            if(obstacleGrid[j][0]==1){
                dp[j][0] = 0;
            }else{
                dp[j][0] = dp[j - 1][0];
            }
        }

        for(int i = 1;i <m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
