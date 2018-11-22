package Array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author Mr.Bao
 * @create 2018-11-15-15:41
 * @since 1.0.0
 */
public class No75SortColors {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while(k <=j){
            if(nums[k]==0){
                swap(nums,k,i);
                i++;
                k++;
            }else if(nums[k]==1){
                k++;
            }else if(nums[k]==2){
                swap(nums,k,j);
                j--;
            }
        }

    }

    void sortColors1(int A[]) {
        int i = -1;
        int j = -1;
        int k = -1;
        for(int p = 0; p < A.length; p ++)
        {
            //根据第i个数字，挪动0~i-1串。
            if(A[p] == 0)
            {
                A[++k] = 2;    //2往后挪
                A[++j] = 1;    //1往后挪
                A[++i] = 0;    //0往后挪
            }
            else if(A[p] == 1)
            {
                A[++k] = 2;
                A[++j] = 1;
            }
            else
                A[++k] = 2;
        }

    }

    public void swap(int[]nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        No75SortColors colors = new No75SortColors();
        int nums[] = new int[]{2,0,2,1,1,0};
        colors.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
