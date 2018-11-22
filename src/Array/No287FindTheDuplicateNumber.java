package Array;

/**
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * @author Mr.Bao
 * @create 2018-11-15-16:11
 * @since 1.0.0
 */
public class No287FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) ++cnt;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(new No287FindTheDuplicateNumber().findDuplicate(nums));
    }
}
