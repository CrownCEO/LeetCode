package Array;

import java.util.ArrayList;
import java.util.List;

/**
 *这种问题都是 递归写法，写递归的时候 想好递归的返回条件是什么，传递的参数是什么
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Note:
 All numbers will be positive integers.
 The solution set must not contain duplicate combinations.
 * @author Mr.Bao
 * @create 2018-11-05-20:22
 * @since 1.0.0
 */
public class No216CombinationSumII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        calc(result,cur,0,k,n,1);
        return result;

    }

    void calc(List<List<Integer>> result,List<Integer> cur,int sum,int k,int n,int level){

        if(sum == n && k==0){
            result.add(new ArrayList<>(cur));
            return;
        }else if(sum > n || k<=0){
            return ;
        }

        for(int i = level;i<=9;i++){
            cur.add(i);
            calc(result,cur,sum + i,k - 1,n,i+1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3; int n = 9;
        No216CombinationSumII sumII = new No216CombinationSumII();
        System.out.println(sumII.combinationSum3(k,n));
    }

}
