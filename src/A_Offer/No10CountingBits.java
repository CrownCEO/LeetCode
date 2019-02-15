package A_Offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有两位是1.因此如果输入9，该函数输出2.
 *
 * 解法：
 * n = n & ( n - 1) 这个操作可以把 n的最右边一位变成0，n能做几次这个操作，就代表n 里面有几个1
 * @author Mr.Bao
 * @create 2019-02-14-16:05
 * @since 1.0.0
 */
public class No10CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
      for(int i = 0;i<=num;i++){
          dp[i] = calac(i);
      }
        return dp;
    }

    public int calac(int num){
        int count = 0;
        while(num>0){
            num = num & (num - 1);
            count ++;
        }
        return count;
    }


}
