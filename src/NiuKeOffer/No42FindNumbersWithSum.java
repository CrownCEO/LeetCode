package NiuKeOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Mr.Bao
 * @create 2019-03-28-23:13
 * @since 1.0.0
 */
public class No42FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array==null || array.length==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result= new ArrayList<>();
        int i = 0;
        int j = array.length - 1;
        while(i<j){
            int curSum = array[i] + array[j];
            if(curSum==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }else if(curSum<sum){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }

}
