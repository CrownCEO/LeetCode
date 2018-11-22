import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.Bao
 * @create 2018-10-15-20:05
 * @since 1.0.0
 */
public class No18_4Sum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            threeSum(nums,i,i+1,target- nums[i]);
            while((i<nums.length - 3)&&(nums[i+1] == nums[i])){
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums,int temp,int start,int target) {
        for(int i = start;i<nums.length-2;i++){

            twoSum(nums,temp,i+1,target - nums[i]);
            while((i<nums.length - 2)&&(nums[i+1] == nums[i])){
                i++;
            }
        }
        return result;
    }

    public void twoSum(int nums[], int temp,int start, int value){
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
                list.add(nums[temp]);
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
        No18_4Sum sum = new No18_4Sum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        sum.fourSum(nums,0);
        System.out.println(sum.result);
    }

}
