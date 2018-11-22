package Array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * @author Mr.Bao
 * @create 2018-10-31-18:39
 * @since 1.0.0
 */
public class No189RotateArray {

    public void rotate(int[] nums, int k) {
        for(int i = 1;i<=k;i++){
            changeNumber(nums,nums.length - 1);
        }
    }

    public void changeNumber(int[] nums,int index){
        int temp = nums[index];
        for(int i = nums.length - 2;i>=0;i--){
            nums[i+1] = nums[i];
        }
        nums[0] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        No189RotateArray array = new No189RotateArray();
        array.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
