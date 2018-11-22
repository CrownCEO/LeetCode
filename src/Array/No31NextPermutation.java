package Array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * @author Mr.Bao
 * @create 2018-10-26-17:13
 * @since 1.0.0
 */
public class No31NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        // 从后向前找到第一个不满足逆序的元素
        int i = nums.length - 2;
        // 注意，这里有=，可以排除含有重复元素的情况
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            // 从右往左找到第一个大于nums[i]的元素
            // 注意等号
            // 也就是从i+1开始找到最小的一个比nums[i]大的元素
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        // 如果nums是逆序，则i是-1，和下面逆置一样
        // System.out.println(i);
        // 将i之后的元素逆置
        int k = nums.length - 1;
        i++;
        for (; i < k; i++, k--)
            swap(nums, i, k);
    }

    // 交换
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{3,2,1};
        int[] nums3 = new int[]{1,1,5};
        int[] nums4 = new int[]{1,7,6,4,2,5};
        No31NextPermutation permutation = new No31NextPermutation();
        permutation.nextPermutation(nums4);
        System.out.println(Arrays.toString(nums4));
    }
}
