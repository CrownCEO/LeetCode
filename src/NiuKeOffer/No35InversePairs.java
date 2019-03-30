package NiuKeOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2019-03-28-16:22
 * @since 1.0.0
 */
public class No35InversePairs {

    public int count = 0;

    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        mergeSort(array,0,array.length - 1);
        return count;

    }

    public void mergeSort(int[] array, int start,int end){
        if(start >=end) {
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid + 1,end);
        merge(array,start, mid,end);
    }

    public void merge(int[] array ,int start, int mid, int end){
        int left = start;
        int right = mid + 1;
        while(left<=mid&&right<=end){
            if(array[left] <= array[right]){
                left++;
            }else{
                count = count + mid - left + 1;
                count=count>1000000007?count%1000000007:count;
                right++;
            }
        }
        Arrays.sort(array,start,end+1);
    }

}
