package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * @author Mr.Bao
 * @create 2018-10-23-22:50
 * @since 1.0.0
 */
public class No74Searcha2DMatrix {

    public static void main(String[] args) {
        No74Searcha2DMatrix searcha2DMatrix = new No74Searcha2DMatrix();
        int[][] matrix = {{1},{3},{23,30,34,50}};

        System.out.println(searcha2DMatrix.searchMatrix(matrix,30));
    }

    public boolean binarySearch(int[] matrix,int target){
        int[] a = matrix;
        int right = a.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == a[mid]) {
                return true;
            } else if (target < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }

        int m = matrix.length;

        for (int i = 0; i < m; i++) {
           int temp =  matrix[i][0];
           if(temp==target){
               return true;
           }else if(temp>target){
               if(i-1>=0){
                   return binarySearch(matrix[i-1],target);
               }else{
                   return false;
               }
           }else{
               if(m==1){
                   return binarySearch(matrix[i],target);
               }else if(i==m-1){
                   return binarySearch(matrix[i],target);
               }
           }
        }
        return false;
    }
}
