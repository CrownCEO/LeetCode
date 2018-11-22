package ReservoirSampling;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * @author Mr.Bao
 * @create 2018-10-10-22:41
 * @since 1.0.0
 */
public class No398RandomPickIndex {

    int[] nums = null;

    public No398RandomPickIndex(int[] nums) {
        this.nums = nums;

    }

    public int pick(int target) {

        int ans = -1;
        int idx = 0;
        int count = 0;
        while(idx < nums.length){
            int temp = nums[idx];
            if(temp==target){
                count = count + 1;
                double r = Math.random();
                if(r < (1.0/ count)){
                  ans = idx;
                }
            }
            idx = idx +
                    1;
        }
        return ans;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */