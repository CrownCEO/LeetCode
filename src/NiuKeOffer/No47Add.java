package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-29-22:54
 * @since 1.0.0
 */
public class No47Add {

    public int Add(int num1,int num2) {
        while(num2!=0){
            int sum = num1 ^ num2;
            int carray = (num1 & num2) <<1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new No47Add().Add(1,2));
    }
}
