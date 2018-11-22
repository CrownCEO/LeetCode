package Array;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * @author Mr.Bao
 * @create 2018-11-21-9:01
 * @since 1.0.0
 */
public class No48RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0;i<n/2;i++){
            int []temp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = temp;
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new No48RotateImage().rotate(matrix);
        for(int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
