package Array;

import java.util.*;

/**
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 Example:

 Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 Follow up:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @author Mr.Bao
 * @create 2018-10-31-21:37
 * @since 1.0.0
 */
public class No209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1); // 注意，初始值
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - s)) {
                len = Math.min(i - map.get(sum - s), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int s = 7;
        No209MinimumSizeSubarraySum sum = new No209MinimumSizeSubarraySum();
        System.out.println(sum.minSubArrayLen(s, nums));
    }

}
