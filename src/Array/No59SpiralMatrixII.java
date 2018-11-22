package Array;

/**
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @author Mr.Bao
 * @create 2018-10-22-22:37
 * @since 1.0.0
 */
public class No59SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n- 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while(left<=right){
            for(int i = left;i<=right;i++) {
                result[top][i] = count++;
            }
            if(left< right){
                for(int i = top + 1;i<bottom;i++){
                    result[i][right] = count++;
                }
                for(int i = right;i > left;i--){
                    result[bottom][i] = count++;
                }
                for(int i = bottom;i>top;i--){
                    result[i][left] = count++;
                }
            }
            left++;right--;top++;bottom--;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
