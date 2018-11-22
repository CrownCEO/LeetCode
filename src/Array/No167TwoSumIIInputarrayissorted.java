package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:
 * @author Mr.Bao
 * @create 2018-10-31-18:22
 * @since 1.0.0
 */
public class No167TwoSumIIInputarrayissorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int value = numbers[i] + numbers[j];
            if(value == target){
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
            else if(i<j &&value < target){
                i++;
            }
            else if(i<j&&value > target){
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        No167TwoSumIIInputarrayissorted sorted = new No167TwoSumIIInputarrayissorted();

        System.out.println(Arrays.toString(sorted.twoSum(numbers,9)));
    }

}
