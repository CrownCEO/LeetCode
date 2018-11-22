package Array;

import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2018-11-21-21:35
 * @since 1.0.0
 */
public class No674LongestContinuousInIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(new No674LongestContinuousInIncreasingSubsequence().findLengthOfLCIS(nums));
    }
}
