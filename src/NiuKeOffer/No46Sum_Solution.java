package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-29-22:46
 * @since 1.0.0
 */
public class No46Sum_Solution {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n >0 && (sum+=Sum_Solution(n-1))>0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new No46Sum_Solution().Sum_Solution(100));
    }

}
