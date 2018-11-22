package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

 Note that the row index starts from 0.
 * @author Mr.Bao
 * @create 2018-10-28-21:10
 * @since 1.0.0
 */
public class No119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        int[][] k = new int[34][34];
        List<Integer> result = new ArrayList<>();
        if(rowIndex==0){
            result.add(1);
            return result;
        }
        if(rowIndex==1){
            result.add(1);
            result.add(1);
            return result;
        }
        result.add(1);
        for(int i = 0;i<k.length;i++){
            k[i][0] = 1;
            k[i][i] = 1;
        }

        for(int i =2;i<=rowIndex;i++){
            for(int j = 1;j<i;j++){
               k[i][j] = k[i-1][j] + k[i-1][j-1];
               if(i==rowIndex){
                   result.add(k[i][j]);
               }

            }
        }
        result.add(1);
    return result;
    }

    public static void main(String[] args) {
        No119PascalsTriangleII pascalsTriangleII = new No119PascalsTriangleII();
        System.out.println(pascalsTriangleII.getRow(3));
    }
}
