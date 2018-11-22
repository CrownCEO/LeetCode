package Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * @author Mr.Bao
 * @create 2018-10-29-19:36
 * @since 1.0.0
 */
public class No33SearchinRotatedSortdArray {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while(begin<=end){
            int mid = (begin + end) /2;
            if(target== nums[mid]) {
                return mid;
            }
            if(nums[mid]>nums[begin]){
                if(target>=nums[begin]&&target<=nums[mid]){
                    end = mid - 1;
                }else{
                    begin = mid +1;
                }
            }else if(nums[mid] < nums[begin]){
                if(target>=nums[mid]&&target<=nums[end]){
                    begin = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                begin ++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3};
        No33SearchinRotatedSortdArray searchinRotatedSortdArray = new No33SearchinRotatedSortdArray();
        System.out.println(searchinRotatedSortdArray.search(nums,5));
    }

}
