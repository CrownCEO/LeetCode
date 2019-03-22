package NiuKeOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2019-03-17-20:31
 * @since 1.0.0
 */
public class No19PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        if(matrix==null||matrix.length==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while(result.size() < n * m){
            if(result.size()>=n * m){
                return result;
            }
            for(int col = left;col<=right;col++){
                result.add(matrix[top][col]);
            }
            top++;
            if(result.size()>=n*m){
                return result;
            }
            for(int row = top;row<=bottom;row++){
                result.add(matrix[row][right]);
            }
            right--;
            if(result.size()>=n*m){
             return result;
            }
            for(int col = right;col>=left;col--){
                result.add(matrix[bottom][col]);
            }
            bottom--;
            if(result.size()>=n*m){
                return result;
            }
            for(int row = bottom;row>=top;row--){
                result.add(matrix[row][left]);
            }
            left++;
        }
        return result;
    }
}
