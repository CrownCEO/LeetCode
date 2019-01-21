package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

 Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.
 * @author Mr.Bao
 * @create 2019-01-15-23:13
 * @since 1.0.0
 */
public class No368LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new No368LargestDivisibleSubset().largestDivisibleSubset(nums));
    }
}
