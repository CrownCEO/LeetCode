package temp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Mr.Bao
 * @create 2018-10-10-20:25
 * @since 1.0.0
 */
public class Test5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String temp0 = scanner.nextLine();
        int n = Integer.parseInt(temp0.split(" ")[0]);
        int m = Integer.parseInt(temp0.split(" ")[1]);
        String temp1 = scanner.nextLine();
        Vector<Integer> v = new Vector<>();
        for(int i = 0;i<n;i++){
            v.add(Integer.parseInt(temp1.split(" ")[i]));
        }
        for (int i = 0; i < m; i++) {
            Integer[] temp = v.toArray(new Integer[v.size()]);
            int[] array = getMinIndex(temp);
            int value = array[0];
            int index = array[1];
            int result = 0;
            int nextIndex = 0;

            if(index-1<0){
                nextIndex = index+1;
            }
            else if(index+1>=temp.length){
                nextIndex = index-1;
            }else{
                if(temp[index-1]<temp[index+1]){
                    nextIndex = index-1;
                }else{
                    nextIndex = index+1;
                }

            }
            result = temp[index] + temp[nextIndex];
            v.set(index,result);
            v.remove(nextIndex);
        }
        Integer[] temp = v.toArray(new Integer[v.size()]);
        int[] array = getMinIndex(temp);
        System.out.println(array[0]);
    }

    public static int[] getMinIndex(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int minIndex = 0;
        int[] arrnew = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[minIndex] > arr[i + 1]) {
                minIndex = i + 1;
            }
        }
        arrnew[0] = arr[minIndex];
        arrnew[1] = minIndex;

        return arrnew;
    }


}
