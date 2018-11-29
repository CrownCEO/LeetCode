package Array;


import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2018-11-29-20:57
 * @since 1.0.0
 */
public class No731SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if ( k <= 1) {
            return 0;
        }

        int n = nums.length;
        long p = 1L;
        int i = 0, total = 0;
        for (int j = 0; j < n; j++){
            p *= nums[j];
            while (p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        System.out.println(new No731SubarrayProductLessThanK().numSubarrayProductLessThanK(nums,100));

    }
}
