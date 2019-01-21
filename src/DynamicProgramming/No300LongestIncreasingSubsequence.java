package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * @author Mr.Bao
 * @create 2019-01-07-20:54
 * @since 1.0.0
 */
public class No300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
            if (dp[i] ==0){
                dp[i] = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new No300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
