package NiuKeOffer;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

/**
 * @author Mr.Bao
 * @create 2019-03-22-22:07
 * @since 1.0.0
 */
public class No29GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1, 5};
        System.out.println(new No29GetLeastNumbers_Solution().GetLeastNumbers_Solution(array, 2));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0) {
            return new ArrayList<>();
        }
        if(k > input.length || k==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if(index <k - 1){
                index = partition(input,index + 1,end);
            }else{
                index = partition(input,start,index - 1);
            }
        }
        for(int i = 0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }

    public int partition(int[] input, int start, int end) {
        int pivolt = input[end];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && input[i] <= pivolt) {
                i++;
            }
            while (i < j && input[j] >= pivolt) {
                j--;
            }
            swap(input, i, j);
        }
        swap(input, i, end);
        return i;
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
