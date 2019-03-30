package NiuKeOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.Bao
 * @create 2019-03-28-10:37
 * @since 1.0.0
 */
public class No32PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0){
            return "";
        }
        Integer[] array = new Integer[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            array[i] = numbers[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 + ""+o2).compareTo((o2 + "" +o1 ));
            }
        });
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<array.length;i++){
            s = s.append(array[i]);
        }
        return s.toString();
    }
}
