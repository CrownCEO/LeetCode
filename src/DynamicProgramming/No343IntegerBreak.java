package DynamicProgramming;

/**
 *
 * 可以看出如果n>4那么n可以一直取3直到n<=4, 这样的乘积最大.
 * @author Mr.Bao
 * @create 2019-01-03-21:04
 * @since 1.0.0
 */
public class No343IntegerBreak {

    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int sum = 1;
        while(n>4){
         sum = sum * 3;
         n = n - 3;
        }
        sum = sum * n;
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new No343IntegerBreak().integerBreak(n));
    }
}
