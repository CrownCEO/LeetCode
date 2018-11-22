import java.util.*;

/**
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.
 * @author Mr.Bao
 * @create 2018-10-15-10:39
 * @since 1.0.0
 */
public class No15_3Sum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            twoSum(nums,i+1,0 - nums[i]);
            while((i<nums.length - 2)&&(nums[i+1] == nums[i])){
                i++;
            }
        }
        return result;
    }

    public void twoSum(int nums[], int start, int value){
        int begin = start;
        int end = nums.length - 1;
        while(begin < end){
            int numValue = nums[begin] + nums[end];
            if(numValue>value){
                end--;
            }else if(numValue<value){
                begin++;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[start - 1]);
                list.add(nums[begin]);
                list.add(nums[end]);
                result.add(list);
                while(begin < end && nums[begin]==nums[begin+1]){
                    begin++;
                }
                while(begin < end && nums[end]==nums[end-1]){
                    end--;
                }
                begin++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        No15_3Sum sum = new No15_3Sum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        sum.threeSum(nums);
        System.out.println(sum.result);
    }
}
