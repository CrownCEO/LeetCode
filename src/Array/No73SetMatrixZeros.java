package Array;

/**使用数组中没有0的行作为 空间 来存储
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * @author Mr.Bao
 * @create 2018-10-23-22:10
 * @since 1.0.0
 */
public class No73SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        int noZeroRawIndex = -1;
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < rawLength; i++) {
            int index = 0;
            for (index = 0; index < colLength; index++) {
                if (matrix[i][index] == 0) {
                    break;
                }
            }
            if (index == colLength) {
                noZeroRawIndex = i;
                break;
            }
        }

        if (noZeroRawIndex == -1) {
            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        } else {
            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[noZeroRawIndex][j] = 0;
                    }
                }
            }

            for (int i = 0; i < rawLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (i == noZeroRawIndex) {
                        continue;
                    }
                    if (matrix[i][j] == 0) {
                        for (int j2 = 0; j2 < colLength; j2++) {
                            matrix[i][j2] = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < colLength; i++) {
                if (matrix[noZeroRawIndex][i] == 0) {
                    for (int j = 0; j < rawLength; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}
