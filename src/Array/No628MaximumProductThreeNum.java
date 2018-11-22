package Array;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * @author Mr.Bao
 * @create 2018-11-22-22:52
 * @since 1.0.0
 */
public class No628MaximumProductThreeNum {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        if(nums[n]<0){
            return nums[n] * nums[n-1] * nums[n - 2];
        }else{

            int a = nums[0] * nums[1] * nums[n];
            int b = nums[n] * nums[n-1] * nums[n - 2];
            return a>b?a:b;
        }

    }

    /**
     * 这种做法记录的了最大的 第二大的 第三大的 最小的 第二小的
     * 然后比较 最大的 * 第二大的 * 第三大的 和  最大的 * 最小的 * 第二小的哪个 值最大
     * 因为可能有负值，两个负值相乘 就是正值
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            int num = nums[i];
            if(num >= largest){
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            } else if(num >= secondLargest){
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num >= thirdLargest){
                thirdLargest = num;
            }

            if(num <= smallest){
                secondSmallest = smallest;
                smallest = num;
            } else if(num <= secondSmallest){
                secondSmallest = num;
            }
        }
        return Math.max((largest*secondLargest*thirdLargest), (smallest*secondSmallest*largest));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new No628MaximumProductThreeNum().maximumProduct(nums));
    }
}
