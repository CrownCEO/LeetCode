package A_Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个集合求全排列，但是有重复的数字
 *
 *解法：
 * 例如假设输入的数组为[1,1,2]。则当第一个1被添加进结果集时，可以继续使用第二个1作为元素添加进结果集
 * 从而生成112。同理，当试图将第二个1作为第一个元素添加进结果集时，只要第一个1还没有被使用过，则不可以使用第二个1.
 * 因此，112不会被重复的添加进结果集。
 * 其实这个算法保证了所有重复的数组在结果集中的顺序和原始输入数组中的顺序是相同的。假设将[1,1,2]表示为
 * [1,1#,2]，那么结果集中会确保1永远在数值1#的前面，从而避免了11#2和1#12的重复情况出现。
 * @author Mr.Bao
 * @create 2019-02-15-16:34
 * @since 1.0.0
 */
public class No12PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        //排序有利于判断重复值
        Arrays.sort(nums);
        //深度优先搜索
        dfs(list,array,nums,used);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> array, int[] nums, boolean[] used){
        if(array.size() == nums.length){
            list.add(new ArrayList<>(array));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) {
                continue;
            }
            //下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if(i > 0&& nums[i - 1] == nums[i] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            array.add(nums[i]);
            dfs(list,array,nums,used);
            used[i] = false;
            array.remove(array.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new No12PermutationsII().permuteUnique(nums));
    }


}
