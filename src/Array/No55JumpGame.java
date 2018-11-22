package Array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.  Each element in the array represents your maximum jump length at that position.  Determine if you are able to reach the last index.
 *
 * @author Mr.Bao
 * @create 2018-10-22-20:38
 * @since 1.0.0
 */
public class No55JumpGame {

    public boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1]) - 1;
            if(dp[i]<0){
                return false;
            }
        }

        if(dp[nums.length-1]>=0){
            return true;
        }else{
            return false;
        }

    }
}
