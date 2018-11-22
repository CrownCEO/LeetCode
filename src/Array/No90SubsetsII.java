package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *初始结果集合只有空集，往里面一个一个 添加，下次添加是遍历结果集中的部分，是从上次同一个数添加前的位置开始
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * @author Mr.Bao
 * @create 2018-11-08-10:32
 * @since 1.0.0
 */
public class No90SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int previous = 0;

        for(int i = 0;i<nums.length;i++){

            List<List<Integer>> temp = new ArrayList<>();
            int current = 0;
            if(i>0&&nums[i]==nums[i-1]){
                current = previous;
            }

            for(int j = current;j<result.size();j++){
                List<Integer> temp1 = result.get(j);
                List<Integer> a = new ArrayList<>(Arrays.asList(new Integer[temp1.size()]));
                Collections.copy(a,temp1);
                a.add(nums[i]);
                temp.add(a);


            }
            previous = result.size();
            result.addAll(temp);

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
