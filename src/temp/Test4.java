package temp;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Mr.Bao
 * @create 2018-10-09-19:39
 * @since 1.0.0
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        String l = lines[0];
        String r = lines[1];
        int count = 0;
        int strl = l.length();
        int strr = r.length();
        for(long i = Long.parseLong(l);i<Math.pow(10,strl);i++){
            if(isReverse(i)){
                count = count+1;
            }
        }

        for ( int i = strl+1; i <strr; i++) {
            int temp = (int) Math.pow(9,i-1);
            count = count +temp;
        }

        for (long i = (long) Math.pow(10,strr); i <Long.parseLong(r); i++) {
                if(isReverse(i)){
                    count = count+1;
                }
        }
        System.out.println(count);
    }

    public static boolean isReverse(long x) {

        String str = x + "";
        if(str.length() ==1){
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return true;
        }
        return false;
    }
}
