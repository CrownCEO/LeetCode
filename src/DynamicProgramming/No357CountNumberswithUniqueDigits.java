package DynamicProgramming;

/**Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * 一位数的满足要求的数字是10个(0到9)，二位数的满足题意的是81个，[10 - 99]这90个数字中去掉[11,22,33,44,55,66,77,88,99]这9个数字，还剩81个。通项公式为f(k) = 9 * 9 * 8 * ... (9 - k + 2)，那么我们就可以根据n的大小，把[1, n]区间位数通过通项公式算出来累加起来即可
 * @author Mr.Bao
 * @create 2019-01-15-20:47
 * @since 1.0.0
 */
public class No357CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int result = 0;
        for(int i = 1;i<=n;i++){
            result = result + count(i);
        }
        return result;
    }

    public int count(int k){
        if(k==1){
            return 10;
        }
        int res = 9;
        for(int i = 9;i>=11 - k;i--){
            res = res * i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No357CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(2));
    }
}
