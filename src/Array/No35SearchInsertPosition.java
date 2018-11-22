package Array;

/**二分查找
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * @author Mr.Bao
 * @create 2018-10-22-19:44
 * @since 1.0.0
 */
public class No35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<target){
                continue;
            }else if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        No35SearchInsertPosition position = new No35SearchInsertPosition();
        System.out.println(position.searchInsert(nums,target));
    }
}
