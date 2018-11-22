package Array;

import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2018-11-22-23:10
 * @since 1.0.0
 */
public class No414ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length<3){
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(num == largest || num == secondLargest || num == thirdLargest){
                continue;
            }
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
        }
        return thirdLargest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,1};
        System.out.println(new No414ThirdMaximumNumber().thirdMax(nums));
    }

}
