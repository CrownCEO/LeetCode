package DynamicProgramming;

/**
 * @author Mr.Bao
 * @create 2019-01-03-23:21
 * @since 1.0.0
 */
public class No70ClimbingStairs {

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i<n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new No70ClimbingStairs().climbStairs(3));
    }
}
