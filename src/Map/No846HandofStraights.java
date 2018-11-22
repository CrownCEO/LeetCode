package Map;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 *
 * @author Mr.Bao
 * @create 2018-10-11-22:14
 * @since 1.0.0
 */
public class No846HandofStraights {


    public static boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        int length = hand.length;
        if (length % W != 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (map.get(hand[i]) == null) {
                map.put(hand[i], 1);
            } else {
                int count = map.get(hand[i]) + 1;
                map.put(hand[i], count);
            }
        }
       while(true){
            int size = map.keySet().size();
            if(size==0){
                break;
            }
            int minKey = Collections.min(map.keySet());
            for (int j = minKey; j < minKey+ W; j++) {
                if (map.get(j) != null && map.get(j) > 0) {
                    int count = map.get(j) - 1;
                    map.put(j, count);
                    if(count==0){
                        map.remove(j);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,3,3,4,7,8};
        System.out.println(isNStraightHand(hand,3));
    }

}
