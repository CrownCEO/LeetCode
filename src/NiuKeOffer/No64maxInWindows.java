package NiuKeOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mr.Bao
 * @create 2019-03-30-21:31
 * @since 1.0.0
 */
public class No64maxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null || num.length==0 || size==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int i = 0;i<num.length;i++){
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }
            queue.addLast(i);

            if(queue.peekFirst() == i - size){
                queue.pollFirst();
            }
            if(i >= size - 1){
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,2,6,2,5};
        System.out.println(new No64maxInWindows().maxInWindows(array,3));
    }
}

