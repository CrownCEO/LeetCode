package Array;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * @author Mr.Bao
 * @create 2018-10-23-21:32
 * @since 1.0.0
 */
public class No64MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i = 1;i< n;i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        if(m==1){
            return  dp[0][n-1];
        }

        for(int i = 1;i< m;i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        if(n==1){
            return  dp[m-1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                int min = Math.min(grid[i][j] + dp[i-1][j],grid[i][j] + dp[i][j-1]);

                dp[i][j] = min;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] temp = new int[][]{{1,2},{1,1}};
        int[][] temp1 = new int[][]{{0}};
        No64MinimumPathSum sum = new No64MinimumPathSum() ;
        System.out.println(sum.minPathSum(temp));}
}
