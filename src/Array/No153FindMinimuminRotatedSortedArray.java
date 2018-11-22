package Array;

/**
 *
 * 和右边的相比较，返回i  和左边的相比较 返回j
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * @author Mr.Bao
 * @create 2018-10-31-19:07
 * @since 1.0.0
 */
public class No153FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,0,1};
        No153FindMinimuminRotatedSortedArray array = new No153FindMinimuminRotatedSortedArray();
        System.out.println(array.findMin(nums));
    }
}
