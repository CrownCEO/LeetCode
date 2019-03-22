package A_Offer;

import java.util.Arrays;

/**leecode 493
 * 给定一个数组，统计出满足 条件的 数对有几对
 * i < j and nums[i] > 2 * nums[j]
 * 解法： 还是使用的归并排序的思路，将数组 切分成两半 直到切分为以一个数为单位，然后再进行比较，在比较的过程中，
 * 如果前面数组的 数据小于等于 2倍的右边的数据，左边的数据索引++，
 * 如果前面数组的 数据 大于 2倍的右边的数据，逆序对个数 加上mid - left + 1,
 * 因为左边剩余的 都会大于 右边的，接着将 右边的数据索引++
 * 循环继续进行的条件是 left<=mid && right <=end
 * 接着将数组的开始到 结束的位置排序，保证数据有序
 * @author Mr.Bao
 * @create 2019-02-22-9:49
 * @since 1.0.0
 */
public class No36ReversePairsI {
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        mergeSort(nums,0,nums.length - 1);
        return cnt;
    }

    public void mergeSort(int[] nums,int start, int end){
        if(start >= end) return ;
        int mid = start + (end - start) / 2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid + 1,end);
        merge(nums,start,mid, end);
    }

    public void merge(int[]nums,int start,int mid, int end){
        int left = start,right = mid + 1;
        while(left <=mid && right <= end){
            if((long)nums[left]<=(long)2 * nums[right]){
                left++;
            }else{
                cnt += mid - left + 1;
                right++;
            }
        }
        Arrays.sort(nums, start, end + 1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        int[] nums2 = new int[]{2,4,3,5,1};
        System.out.println(new No36ReversePairsI().reversePairs(nums));
    }

}
