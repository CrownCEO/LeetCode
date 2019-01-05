package DynamicProgramming;

/**
 * 第一次将第一位置为0  用之前的方法计算一次
 * 第二次将最后一个位置置为0，用之前的方法再计算一次
 * 比较两次得到的值，取最大的值
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author Mr.Bao
 * @create 2018-12-14-9:53
 * @since 1.0.0
 */
public class No213HouseRobberII {

    public int rob(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int temp = nums[0];
        nums[0] = 0;
        int a = getValue(nums);
        nums[0] = temp;
        nums[nums.length - 1] = 0;
        int b = getValue(nums);
        return Math.max(a,b);
    }

    public int getValue(int[] nums){


        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        System.out.println(new No213HouseRobberII().rob(nums));
    }
}
