package Array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 *往空集合中 一个一个 添加-当碰到
 *  * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * @author Mr.Bao
 * @create 2018-10-25-22:22
 * @since 1.0.0
 */
public class No78Subsets2 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0;i<nums.length;i++){

            List<List<Integer>> temp = new ArrayList<>();
            for(int j = 0;j<result.size();j++){
                List<Integer> temp1 = result.get(j);
                List<Integer> a = new ArrayList<>(Arrays.asList(new Integer[temp1.size()]));
                Collections.copy(a,temp1);
                a.add(nums[i]);
                temp.add(a);


            }
            result.addAll(temp);

        }
        return result;
    }

    public static void main(String[] args) {
        No78Subsets2 subsets = new No78Subsets2();
        int[] nums = new int[]{1,4,4,4};
        System.out.println(subsets.subsets(nums));
    }
}
