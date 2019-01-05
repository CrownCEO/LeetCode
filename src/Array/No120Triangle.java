package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Error ！！！！！ 正确的在DynamicProgramming 文件夹下
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author Mr.Bao
 * @create 2018-10-28-21:35
 * @since 1.0.0
 */
public class No120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;
        for(int i =0;i<triangle.size();i++){
            List<Integer> temp = triangle.get(i);
            int a =  Collections.min(temp);
            result  = result+ a;
        }
        return result;
    }

    public static void main(String[] args) {
        No120Triangle triangle = new No120Triangle();
//        System.out.println(triangle.minimumTotal());
    }

}
