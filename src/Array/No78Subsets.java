package Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * @author Mr.Bao
 * @create 2018-10-25-21:23
 * @since 1.0.0
 */
public class No78Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();

        int length = nums.length;
        int start = 0;
        int end = (1<<length) - 1;
        boolean isnull = true;
        for(int i = start;i<=end;i++){
            List<Integer> integers = new ArrayList<>();
            for(int j = 0;j<nums.length;j++){

                System.out.println((1<<j) & i);
                if(((1<<j) & i)!=0){
                    isnull = false;
                    integers.add(nums[j]);
                }
            }
            result.add(integers);
        }
        if(isnull){
            result.add(null);
        }

        return result;
    }

    public static void main(String[] args) {
        No78Subsets subsets = new No78Subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets.subsets(nums));
    }
}
