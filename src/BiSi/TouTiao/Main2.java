package BiSi.TouTiao;

import java.util.Scanner;

/**
 * @author Mr.Bao
 * @create 2019-03-16-10:55
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String m  = sc.next();
            System.out.println(repair(m,0));


        }
    }

    public static String repair(String s,int st){
        for(int i = st;i<s.length() - 1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                if(i+2 < s.length() && s.charAt(i) == s.charAt(i+2)){
                    return repair(s.substring(0,i) + s.substring(i+1),i);
                }else{
                    if(i - 2 >=0 && s.charAt(i-1) == s.charAt(i-2)){
                        return repair(s.substring(0,i) + s.substring(i+1),i-2);
                    }
                }
            }
        }
        return s;
    }
}
