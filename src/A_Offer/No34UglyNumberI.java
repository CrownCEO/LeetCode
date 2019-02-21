package A_Offer;

import DynamicProgramming.No343IntegerBreak;

/**leetcode 263 判断一个数是不是丑数
 * 解法：
 * 依次判断能否被 2，3，5 整除，如果能整除，则把2，3，5 都除掉，如果最后还剩1 则
 * 证明是 丑数，在计算前如果 数字为负数，直接返回 false
 * @author Mr.Bao
 * @create 2019-02-20-18:10
 * @since 1.0.0
 */
public class No34UglyNumberI {

    public boolean isUgly(int num) {

        if(num<=0){
            return false;
        }
        while(num%2==0){
            num = num / 2;
        }
        while(num%3==0){
            num = num / 3;
        }
        while(num%5==0){
            num = num / 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new No34UglyNumberI().isUgly(6));
    }
}
