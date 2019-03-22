package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * @author Mr.Bao
 * @create 2018-12-14-9:59
 * @since 1.0.0
 */
public class No279PerfectSquares {

    public int numSquares(int n) {
        int[]dp = new int[n + 1];
        List<Integer> result = new ArrayList<>();
        for(int i = 1;i<=Math.sqrt(n);i++){
            result.add(i * i);
            dp[i * i] = 1;
        }
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            int ans = Integer.MAX_VALUE;
            for(int j = 0;j<result.size();j++){
                if(result.get(j) > i){
                    break;
                }
                ans = Math.min(ans,1 + dp[i - result.get(j)]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new No279PerfectSquares().numSquares(12));
    }
}
