package temp;

import java.util.*;

/**
 * @author Mr.Bao
 * @create 2018-09-15-20:23
 * @since 1.0.0
 */
public class Test {


    public static int sum(int shifts[],int index){
        int sum = 0;
        for(int i = index;i<shifts.length;i++){
            sum = sum + shifts[i];
        }
        return sum % 26;
    }

    public static void main(String[] args) {
//        String S = "abc";
//        int shifts[] =  {3,5,9};
//        char[] chars = S.toCharArray();
//        char[] result= new char[chars.length];
//        for(int i=0;i<chars.length;i++){
//            result[i] = (char) (chars[i] + sum(shifts,i));
//        }
//        System.out.println(String.valueOf(result));

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(1);        set.add(-1);
        Iterator<Integer> temp = set.iterator();
        while(temp.hasNext()){
            System.out.println(temp.next());
        }

    }
}
