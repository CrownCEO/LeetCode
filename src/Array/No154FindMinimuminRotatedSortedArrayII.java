package Array;

/**z
 * 与上一道题 相比，这道题的特点在于里面出现了重复的数字，需要加一个判断，如果nums[mid]==nums[right]
 * 需要right--,将数字跳过
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 The array may contain duplicates.
 * @author Mr.Bao
 * @create 2018-10-31-20:14
 * @since 1.0.0
 */
public class No154FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] == nums[right]){
                right--;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,3};
        No154FindMinimuminRotatedSortedArrayII array = new No154FindMinimuminRotatedSortedArrayII();
        System.out.println(array.findMin(nums));
    }

}
