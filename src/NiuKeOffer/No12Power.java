package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-17-10:57
 * @since 1.0.0
 */
public class No12Power {

    public double Power(double base, int exponent) {
        double result = 1;
        int p = Math.abs(exponent);
        while(p>0){
            //用来判断是偶数还是奇数
            if((p &1) >0){
                result = result * base;
            }
            base = base * base;
            p>>=1;
        }

        return exponent >=  0?result:1.0/result;
    }

    public static void main(String[] args) {
        System.out.println(  new No12Power().Power(2,5));

    }
}
