package Array;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * @author Mr.Bao
 * @create 2018-11-05-19:56
 * @since 1.0.0
 */
public class No152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if( nums==null || nums.length==0){
            return 0;
        }
        int global = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1;i<nums.length;i++){
            int maxTemp = Math.max(max * nums[i], min * nums[i]);
            int minTemp = Math.min(max * nums[i], min * nums[i]);

            max = Math.max(maxTemp,nums[i]);
            min = Math.min(minTemp,nums[i]);

            global = Math.max(global,max);
        }
        return global;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,-2,4};
        No152MaximumProductSubarray subarray = new No152MaximumProductSubarray();
        System.out.println(subarray.maxProduct(nums));
    }

}
