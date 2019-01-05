package DynamicProgramming;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * @author Mr.Bao
 * @create 2018-12-14-9:59
 * @since 1.0.0
 */
public class No279PerfectSquares {

    public int numSquares(int n) {
        int a = (int) Math.sqrt(n);
        int[] num = new int[a];
        num[0] = 0;
        for(int i = 1;i<num.length;i++){
            num[i] = i * i + num[i-1];
        }
        for(int i = 0;i<num.length;i++){

        }
        return 0;
    }
}
