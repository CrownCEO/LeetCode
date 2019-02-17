package A_Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 解法：
 * 螺旋打印矩阵，第一步：从左到右，第二步，从上到下，第三步，从右到左，第四步，从下到上。
 * 每一步打印的时候，限定行或者列的范围后遍历，然后将对应的行或者列，减小或者增加。
 * @author Mr.Bao
 * @create 2019-02-16-17:29
 * @since 1.0.0
 */
public class No20SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix==null||matrix.length==0){
            return result;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        while(result.size() < n * m){
            if(result.size() >= n * m){
                return result;
            }
            for(int col = left;col<=right;col++){
                result.add(matrix[top][col]);
            }
            top++;
            if(result.size() >= n * m){
                return result;
            }
            for(int row = top;row<=bottom;row++){
                result.add(matrix[row][right]);
            }
            right--;
            if(result.size() >= n * m){
                return result;
            }
            for(int col = right;col>=left;col--){
                result.add(matrix[bottom][col]);
            }
            bottom--;
            if(result.size() >= n * m){
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
