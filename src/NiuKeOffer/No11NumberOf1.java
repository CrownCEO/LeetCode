package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-17-10:49
 * @since 1.0.0
 */
public class No11NumberOf1 {


    public int NumberOf1(int n) {
        int count = 0;
        while(n > 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
