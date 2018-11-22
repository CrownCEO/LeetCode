package Array;

import java.util.Arrays;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.
 * @author Mr.Bao
 * @create 2018-10-28-20:33
 * @since 1.0.0
 */
public class No81SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[begin] < nums[mid]) {//左单调
                if (nums[begin] <= target && nums[mid] >= target)
                    end = mid - 1;
                else begin = mid + 1;
            }
            else if(nums[begin] > nums[mid]){//右单调
                if (nums[mid] <= target && nums[end] >= target)
                    begin = mid + 1;
                else end = mid - 1;
            }else
                begin++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        No81SearchinRotatedSortedArrayII arrayII = new No81SearchinRotatedSortedArrayII();
        System.out.println(arrayII.search(nums,1));

    }
}
