/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * @author Mr.Bao
 * @create 2018-10-19-9:08
 * @since 1.0.0
 */
public class No215KthElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        if(k<1 || nums==null){
            return 0;
        }
        return findK(nums,nums.length - k,0,nums.length-1);
    }

    public int findK(int[] nums, int k,int start, int end){


        int left = start;
        int right = end;
        int pivolt = nums[end];

        while(true){
            while(left<right&&nums[left]<pivolt){
                left++;
            }
            while(left<right&&nums[right]>=pivolt){
                right--;
            }
            if(left==right){
                break;
            }
            swap(nums,left,right);
        }
        swap(nums, left,end);
        if(k==left){
            return pivolt;
        }else if(k<left){
            return findK(nums,k,start,left -1);
        }else{
            return findK(nums,k,left,end);
        }
    }

    public void swap(int[] nums, int a,int b){
        int temp =nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        No215KthElementinanArray array = new No215KthElementinanArray();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(array.findKthLargest(nums,2));
    }

}
