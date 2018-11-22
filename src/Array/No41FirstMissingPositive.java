package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * @author Mr.Bao
 * @create 2018-10-22-19:53
 * @since 1.0.0
 */
public class No41FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;

        for(int i=0;i<A.length;i++){
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }

        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)
                return i+1;
        }

        return A.length+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int[] nums1 = new int[]{3,4,-1,1};
        int[] nums2 = new int[]{7,8,9,11,12};
        No41FirstMissingPositive positive = new No41FirstMissingPositive();
        System.out.println(positive.firstMissingPositive(nums1));
    }
}
