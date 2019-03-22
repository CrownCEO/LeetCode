package NiuKeOffer;

import java.nio.channels.FileChannel;

/**
 * @author Mr.Bao
 * @create 2019-03-13-22:55
 * @since 1.0.0
 */
public class No7Fibonacci {

    public int Fibonacci(int n) {

        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }else{
            return   Fibonacci(n-1) +  Fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No7Fibonacci().Fibonacci(4));
    }
}
