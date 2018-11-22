import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.Bao
 * @create 2018-10-15-19:47
 * @since 1.0.0
 */
public class No16_3SumClosest {

    List<List<Integer>> result = new ArrayList<>();

    public int threeSumClosest(int[] nums, int target) {
        int temp = target;
        int temp2 =   target;
        Arrays.sort(nums);

        while(result.size()==0){
            for(int i = 0;i<nums.length-2;i++){
                twoSum(nums,i+1,temp - nums[i]);
                while((i<nums.length - 2)&&(nums[i+1] == nums[i])){
                    i++;
                }
            }


            if(result.size()!=0){
                return temp;
            }
            temp++;
            for(int i = 0;i<nums.length-2;i++){
                twoSum(nums,i+1,temp2 - nums[i]);
                while((i<nums.length - 2)&&(nums[i+1] == nums[i])){
                    i++;
                }
            }

            if(result.size()!=0){
                return temp2;
            }
            temp2--;
        }
        return 0;
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
        No16_3SumClosest sum = new No16_3SumClosest();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int result = sum.threeSumClosest(nums,1);
        System.out.println(result);
    }

}
