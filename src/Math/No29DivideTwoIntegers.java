package Math;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.
 不用乘法和除法来计算 两个数的除法
 由于是int类型的除法，因此结果可能超过int的最大值，当超过int的最大值时输出int的最大值
 先判断出除法运算后的结果是正数还是负数，之后将被除数和除数都变成正数，进行进一步计算，
 当被除数小于除数时，返回0，否则，进入循环体，判断被除数包含多少个除数（这里的个数是2的整数倍）
 ，最后返回的结果，要有一个递归的过程，
 * @author Mr.Bao
 * @create 2019-01-21-21:57
 * @since 1.0.0
 */
public class No29DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE: (int)result;
    }

    public long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
//        return negative ? -(divide): (divide);
    }

    public static void main(String[] args) {
        System.out.println(new No29DivideTwoIntegers().divide(10, 3));
    }
}
