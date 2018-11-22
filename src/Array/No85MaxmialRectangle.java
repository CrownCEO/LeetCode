package Array;

/**
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * @author Mr.Bao
 * @create 2018-11-06-21:27
 * @since 1.0.0
 */
public class No85MaxmialRectangle {

    public int maximalRectangle(char[][] matrix) {
        return 0;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        No85MaxmialRectangle rectangle = new No85MaxmialRectangle();
        System.out.println(rectangle.maximalRectangle(matrix));
    }
}
