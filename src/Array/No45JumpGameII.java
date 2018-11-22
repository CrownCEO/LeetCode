package Array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.
 贪心算法 cur:当前跳的最大值
 previous:上一跳的最大值
 *
 * @author Mr.Bao
 * @create 2018-10-22-21:03
 * @since 1.0.0
 */
public class No45JumpGameII {

    public int jump(int[] nums) {
        int cur = 0;
        int previous = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(i>cur){
                return -1;
            }
            if(i>previous){
                previous = cur;
                count++;




            }
            cur = Math.max(cur,i + nums[i]);
        }

    return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,3,3,1,1,1};
        No45JumpGameII gameII = new No45JumpGameII();
        System.out.println(gameII.jump(nums));
    }

}
