package Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * @author Mr.Bao
 * @create 2018-11-20-21:40
 * @since 1.0.0
 */
public class No54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        int n = matrix.length;
        int m = matrix[0].length;
        int left= 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while(result.size() < n * m){
            if(result.size() >= n * m)  break;
            for(int col = left;col<=right;col++){
                result.add(matrix[top][col]);
            }
            top++;
            if(result.size() >= n * m)  break;
            for(int row = top;row<=bottom;row++){
                result.add(matrix[row][right]);
            }
            right--;
            if(result.size() >= n * m)  break;
            for(int col = right;col>=left;col--){
                result.add(matrix[bottom][col]);
            }
            bottom--;
            if(result.size() >= n * m)  break;
            for(int row = bottom;row>=top;row--){
                result.add(matrix[row][left]);
            }
            left++;


        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new No54SpiralMatrix().spiralOrder(matrix));
    }
}
