package DynamicProgramming;

import java.util.List;

/**
 *
动态规划 从下往上计算，dp 数组 存储的是 最后一行的数据

 dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);

 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 * @author Mr.Bao
 * @create 2018-12-11-8:57
 * @since 1.0.0
 */
public class No120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i = 0;i<dp.length;i++){
            dp[i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
