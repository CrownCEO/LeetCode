package A_Offer;

/**leetcode 31
 * 连续子数组的最大和
 * @author Mr.Bao
 * @create 2019-02-20-18:03
 * @since 1.0.0
 */
public class No31MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0;i<nums.length;i++){

            if(currentSum<=0){
                currentSum = nums[i];
            }else{
                currentSum = currentSum + nums[i];
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new No31MaximumSubarray().maxSubArray(nums));
    }

}
