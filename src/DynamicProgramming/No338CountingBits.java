package DynamicProgramming;

/**当前的数和前一个数字想与，之前有1的位置还是1
 * dp 存储的是 当前位置有1的个数
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * @author Mr.Bao
 * @create 2018-12-12-9:02
 * @since 1.0.0
 */
public class No338CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i = 1;i<=num;i++){
            dp[i] = dp[i&(i-1)] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {

    }
}
