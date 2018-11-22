package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * @author Mr.Bao
 * @create 2018-10-22-22:00
 * @since 1.0.0
 */
public class No66PlusOne {

    public int[] plusOne(int[] digits) {

        int[] result;
        int temp = digits[digits.length - 1] +1;
        if(temp>=10){
            digits[digits.length - 1] = 10;
            for(int i = digits.length-1;i>0;i--){

                if(digits[i] >=10){
                        digits[i] = 0;
                        digits[i-1] = digits[i-1] + 1;
                    }
                }
            } else{
            digits[digits.length - 1] = temp;
        }
        if(digits[0] == 10){
            result = new int[digits.length + 1];
            result[0] = 1;
            result[1] = 0;
            if(digits.length==1){
                return result;
            }
            System.arraycopy(digits,1,result,2,digits.length-2);
        }else{
            result = new int[digits.length];
            System.arraycopy(digits,0,result,0,digits.length);
        }


        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        No66PlusOne one = new No66PlusOne();
        int[] result = one.plusOne(nums);
        for(int i = 0;i<result.length;i++ ) {
            System.out.println(result[i]);
        }
    }

}
