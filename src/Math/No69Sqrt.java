package Math;

/**记得讲变量用成long
 * @author Mr.Bao
 * @create 2019-03-22-15:14
 * @since 1.0.0
 */
public class No69Sqrt {

    public int mySqrt(int x) {
        long l = 0;
        long h = x;
        while(l<=h){
            long mid = (h - l)/2 + l;
            long temp = mid * mid;
            if(temp==x){
                return (int) mid;
            }else if(temp >x){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return (int) h;
    }

    public static void main(String[] args) {
        System.out.println(new No69Sqrt().mySqrt(5));
    }

}
