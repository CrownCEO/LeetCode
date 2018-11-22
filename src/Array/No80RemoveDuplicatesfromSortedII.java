package Array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * @author Mr.Bao
 * @create 2018-10-28-20:04
 * @since 1.0.0
 */
public class No80RemoveDuplicatesfromSortedII {

    public int removeDuplicates(int[] A) {
        int i = 0, j = 0; //j去查看原数组进行滤重，i放入滤重后的元素
        int n = A.length;
        while (i < n && j < n) {
            if (j+1 < n && A[j] == A[j+1]){
                A[i] = A[j];
                A[i+1] = A[j];
                i = i+2; //下一个待放入元素应该放在i
                while (j<n&&A[j] == A[i-1]){
                    ++j;
                    //已经放好的最后一个元素在i-1
                }
            } else {
                A[i] = A[j];
                ++i;
                ++j;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        No80RemoveDuplicatesfromSortedII removeDuplicatesfromSortedII = new No80RemoveDuplicatesfromSortedII();
        System.out.println(removeDuplicatesfromSortedII.removeDuplicates(nums));
    }
}
