package A_Offer;

/**leetcode 169 数组中出现次数 超过一半的数字
 * 解法：
 * 定义一个 数字出现的次数，遍历整个数组，当次数为0时，设置value为当前数组中的值，当
 * 次数不为0时，如果数组中的值与当前value相同，则次数加一，如果值不相同，则次数减1.
 * 等遍历完毕，返回的value 就是数组中出现次数超过一半的数字。
 * @author Mr.Bao
 * @create 2019-02-20-17:56
 * @since 1.0.0
 */
public class No29MajorityElement {


    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int times = 0;
        int value = 0;
        for(int i = 0;i<nums.length;i++){
            if(times==0){
              value = nums[i];
              times++;
            }else{
                if(value==nums[i]){
                    times++;
                }else{
                    times--;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2,};
        System.out.println(new No29MajorityElement().majorityElement(nums));
    }
}
