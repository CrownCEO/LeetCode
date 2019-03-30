package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-29-22:36
 * @since 1.0.0
 */
public class No45LastRemaining_Solution {

    public int LastRemaining_Solution(int n, int m) {
        if(n<=0 || m<0){
            return -1;
        }
        int lastInteger = 0;
        for(int i = 2;i<=n;i++){
            lastInteger = (lastInteger + m)%i;
        }
        return lastInteger;
    }

}
