package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * 第一次思考的时候，不知道该如何确定矩形，以及矩形如何移动。（最大子矩阵问题）
 * 根据题意，寻找二维数组中所有可以组成的矩形中面积不超过k的最大值，所以必须要求出可能组成的矩形的面积与k
 * 比较求出最终结果。
 * @author Mr.Bao
 * @create 2019-01-15-21:07
 * @since 1.0.0
 */
public class No363MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
            return 0;
        }
        int col = matrix[0].length;
        if(col==0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        boolean key = col <= row;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        //一行一行的找
        for(int i = 0;i<m;i++){
            //找从第i行开始一直到第0行这i+1行的可能组成的矩形长度
            //这个矩阵为了保存每一列上第j行到第i行的和
            int[] array = new int[n];
            for(int j = i;j>=0;j--){
                //用来保存当前高度下，长度为从0开始到k位置的矩形的结果
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int sum = 0;
                for(int k = 0;k<n;k++){
                    if(key){
                        array[k] += matrix[k][j];
                    }else{
                        array[k] += matrix[j][k];
                    }
                    sum+=array[k];
                    //因为要满足（sum - set 中的元素）<= target,而且sum-set中的元素的值要尽可能的大，
                    //所以也就是要求大于等于sum-target中满足条件的元素的最小的一个，正好TreeSet中提供了这个方法，
                    // 可以很方便的找出这个元素
                    Integer integer = set.ceiling(sum - target);
                    if(integer!=null){
                        result = Math.max(result,sum - integer);
                    }
                    set.add(sum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1},{0,-2,3}};
        System.out.println(new No363MaxSumofRectangleNoLargerThanK().maxSumSubmatrix(matrix,2));
    }
}
