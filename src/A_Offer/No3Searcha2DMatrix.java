package A_Offer;

import Array.No74Searcha2DMatrix;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解法：
 * 1.可以用二分查找，先按照行查找，然后再按照列查找
 * 2.从右上角开始找，具体步骤：首选选取右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数字，剔除这个数字所在的列，
 *；如果该数字小于要查找的数字，剔除这个数字所在的行，也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以
 * 缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 * @author Mr.Bao
 * @create 2019-02-13-16:55
 * @since 1.0.0
 */
public class No3Searcha2DMatrix {

    public static void main(String[] args) {
        No3Searcha2DMatrix searcha2DMatrix = new No3Searcha2DMatrix();
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(searcha2DMatrix.searchMatrix(matrix,30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {


    }
}
