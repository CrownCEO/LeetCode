package Array;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that nums[-1] = nums[n] = -∞.
 * @author Mr.Bao
 * @create 2018-11-15-21:28
 * @since 1.0.0
 */
public class No162FindPeakElement {

    public int findPeakElement(int[] nums) {
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }
        return nums.length - 1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new No162FindPeakElement().findPeakElement(nums));
    }
}
