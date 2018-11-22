package Array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @author Mr.Bao
 * @create 2018-11-04-10:47
 * @since 1.0.0
 */
public class No53MaximumSubarray {

    public int maxSubArray(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int thisSum = 0;
        for(int i = 0;i<nums.length;i++){
            thisSum = thisSum + nums[i];
            if(thisSum>maxSum){
                maxSum = thisSum;
            }
            if(thisSum <0){
                thisSum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        No53MaximumSubarray subarray = new No53MaximumSubarray();
        System.out.println(subarray.maxSubArray(nums));
    }
}
