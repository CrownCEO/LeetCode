package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 * @author Mr.Bao
 * @create 2018-11-20-21:07
 * @since 1.0.0
 */
public class No670MaximumSwap {

    public int maximumSwap(int num) {
        int maxSeen = 0, maxIdx = -1, power = 0, swapIdx1 = 0, swapIdx2 = 0;
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            list.add(digit);
            if(maxSeen > digit){
                swapIdx1 = power;
                swapIdx2 = maxIdx;
            }
            else if(digit > maxSeen){
                maxSeen = digit;
                maxIdx = power;
            }
            num = num/10;
            power++;
        }

        Collections.swap(list, swapIdx1, swapIdx2);

        int result = 0;
        for(int i = 0; i < list.size(); i++){
            result += (int)(Math.pow(10, i) * list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new No670MaximumSwap().maximumSwap(982345));
    }
}
