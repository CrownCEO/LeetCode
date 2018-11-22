package Array;

import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2018-10-26-16:29
 * @since 1.0.0
 */
public class No41FirstMissingPositiveII {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        //排序
        Arrays.sort(nums);
        int k = 1;
        for(int i = 0;i < nums.length ;i++) {
            //去负
            if(nums[i] <= 0) {
                continue;
            }
            //去重
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] != k ) {
                return k;
            }
            k++;
        }

        return nums[nums.length-1]+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int[] nums1 = new int[]{3,4,-1,1};
        int[] nums2 = new int[]{7,8,9,11,12};
        No41FirstMissingPositiveII positive = new No41FirstMissingPositiveII();
        System.out.println(positive.firstMissingPositive(nums2));
    }
}
