import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mr.Bao
 * @create 2018-09-15-18:47
 * @since 1.0.0
 */
public class No1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        for(int i = 0;i<nums.length;i++){
            for(int j = i +1;j <nums.length;j++){
                if ((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> data = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            data.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            if(data.get(temp)!=null){
                result[0] = i;
                result[1] = data.get(temp);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0;i<n;i++){
            data[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int[] result = twoSum(data,target);
        for(int i =0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
