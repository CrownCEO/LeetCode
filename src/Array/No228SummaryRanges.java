package Array;

import java.util.*;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * @author Mr.Bao
 * @create 2018-11-05-20:39
 * @since 1.0.0
 */
public class No228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        if(nums ==null || nums.length ==0){
            return new ArrayList<>();
        }
        List<String> strings = new ArrayList<>();

        List<List<Integer>> map = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        map.add(list);
        for(int i = 1;i<nums.length;i++){
            if(nums[i] - 1 != nums[i-1]){
                list = new ArrayList<>();
                list.add(nums[i]);
                map.add(list);
            }else{
                map.get(map.size() - 1).add(nums[i]);
            }

        }
        for(int i = 0;i<map.size();i++){
            List<Integer> temp = map.get(i);
            String s = null;
            if(temp.size() >= 2){
               s = temp.get(0) + "->" + temp.get(temp.size() - 1);
            }else{
                s = temp.get(0) + "";
            }

            strings.add(s);
        }
        return strings;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        No228SummaryRanges ranges = new No228SummaryRanges();
        System.out.println(ranges.summaryRanges(nums));
    }
}
