package A_Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个集合，打印出全排列
 * 解法：
 * 回溯的题要搞清楚回溯的条件,这里回溯的条件就是array里存储的数据个数等于数组的长度。
 * 然后查找回溯进入下一层的条件是，当前数组中还有没有加入到array中，然后进入到下一层的运算。
 * @author Mr.Bao
 * @create 2019-02-15-16:14
 * @since 1.0.0
 */
public class No12PermutationsI {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        int n = nums.length;
        per(list, array, 0, n, nums);
        return list;
    }

    public void per(List<List<Integer>> list,List<Integer> array,int t,int n, int[]nums){
        if(t > n){
            return;
        }else if(t==n){
            list.add(new ArrayList<>(array));
        }else{
            for(int i = 0;i<n;i++){
                if(!array.contains(nums[i])){
                    array.add(nums[i]);
                    per(list,array,t+1,n,nums);
                    array.remove(array.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new No12PermutationsI().permute(nums));
    }


}
