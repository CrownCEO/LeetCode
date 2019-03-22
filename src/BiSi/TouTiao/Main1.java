package BiSi.TouTiao;

/**
 * @author Mr.Bao
 * @create 2019-03-16-10:46
 * @since 1.0.0
 */
import java.util.Scanner;



public class Main1 {


    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);
        int n = a.nextInt();
        int r = 1024-n;
        if (r==0)
            System.out.println(0);
        int a64;
        int a16;
        int a4;
        int a1;
        a64 = r/64;
        r = r-64*a64;
        a16 = r/16;
        r = r-16*a16;
        a4 = r/4;
        r = r-4*a4;
        a1 = r;
        System.out.println(a4+a16+a4+a1);
    }
}