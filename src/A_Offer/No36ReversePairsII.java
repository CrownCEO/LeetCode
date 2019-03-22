package A_Offer;

import java.util.Arrays;

/**leetcode 532
 * 我最开始以为和上一个题一样，都是求逆序对的，后来发现不是
 * 给定一个数组，和一个数字k,需要找出相差为k 的数组对的个数
 * 解法：
 * 先给数组排序以后，然后可以定义两个指针，从数组第一位和数组第二位
 * 开始遍历。
 * 如果两个数差距小于k,则第二个指针往后移动一步。
 * 如果两个数差距大于k,则第一个指针往后移动一步
 * 如果两个数差距等于k,计数加一，然后如果数字重复的话，
 * 需要移动左指针或者右指针。
 * 如果当左指针和右指针相等的时候，右指针向后移动
 * @author Mr.Bao
 * @create 2019-02-24-20:30
 * @since 1.0.0
 */
public class No36ReversePairsII {

    public int findPairs(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;
        while(right<nums.length){
            int firstNum = nums[left];
            int secNum = nums[right];
            if(secNum - firstNum < k){
                right++;
            }else if(secNum - firstNum > k){
                left++;
            }else{
                count++;
                while(left<nums.length && nums[left]==firstNum){
                    left++;
                }
                while(right<nums.length && nums[right]==secNum){
                    right++;
                }
            }
            if(right==left){
                right++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,1,5};
        int k = 2;
        new No36ReversePairsII().findPairs(nums,k);
    }
}
