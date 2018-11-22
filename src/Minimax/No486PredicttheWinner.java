package Minimax;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
 * Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

 Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 *
 * @author Mr.Bao
 * @create 2018-10-20-22:43
 * @since 1.0.0
 */
public class No486PredicttheWinner {

    public boolean PredictTheWinner(int[] nums){
        int n = nums.length;
        if(n == 0) {
            return true;
        }
        int[][]dp = new int[n+1][n+1];
        int turn = n & 1, sum = 0;
        for(int i = 0;i<n; i++){
            dp[i][i] = turn ==1 ? nums[i] : 0;
            sum += nums[i];
        }

        for(int len=2;len<=n;len++){
            turn ^=1;
            for(int i = 0;i<n - len + 1;i++){
                int j = i + len - 1;
                if(turn==1){
                    dp[i][j] = Math.max(dp[i+1][j] + nums[i], dp[i][j-1] + nums[j]);
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return 2 * dp[0][n - 1] >=sum;
    }

    public static void main(String[] args) {
        int turn = 5 &1;
        System.out.println(turn);
        System.out.println(4 &1);
        int[] nums = new int[]{1,5,233,7};
        No486PredicttheWinner winner = new No486PredicttheWinner();
        winner.PredictTheWinner(nums);
    }
}
