package Array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * @author Mr.Bao
 * @create 2018-11-01-19:56
 * @since 1.0.0
 */
public class No283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        int size = nums.length;

        while(zeroIndex<size && nonZeroIndex<size){
            while(zeroIndex<size && nums[zeroIndex]!=0) zeroIndex++;
            while(nonZeroIndex < size && (nums[nonZeroIndex]==0 || nonZeroIndex<zeroIndex)) nonZeroIndex++;

            //swap the value
            if(zeroIndex<size && nonZeroIndex<size){
                nums[zeroIndex++] = nums[nonZeroIndex];
                nums[nonZeroIndex++] = 0;
            }
        }

    }



    public static void main(String[] args) {
        No283MoveZeroes zeroes = new No283MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        zeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
