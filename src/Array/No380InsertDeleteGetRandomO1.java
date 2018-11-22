package Array;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * @author Mr.Bao
 * @create 2018-11-15-21:52
 * @since 1.0.0
 */
public class No380InsertDeleteGetRandomO1 {

    Map<Integer,Integer> map;
    List<Integer> list;
    int size;

    /** Initialize your data structure here. */
    public No380InsertDeleteGetRandomO1()
    {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val)
    {
        if(map.containsKey(val)) return false;
        else
        {
            list.add(size,val);
            map.put(val,size++);
            return true;
        }
    }



    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val)
    {
        if(!map.containsKey(val)) return false;
        else if(size == 0) map.remove(val);
        else
        {
            int tailKey = list.get(size-1);
            map.put(tailKey,map.get(val));
            list.set(map.get(val),tailKey);
            size--;
            map.remove(val);

        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom()
    {
        Random rdm = new Random();
        return list.get(rdm.nextInt(size));
    }


    public static void main(String[] args) {
        No380InsertDeleteGetRandomO1 randomO1 = new No380InsertDeleteGetRandomO1();
        randomO1.getRandom();
        randomO1.insert(1);
        randomO1.remove(2);
        randomO1.insert(2);
        randomO1.getRandom();
        randomO1.remove(1);
        randomO1.insert(2);
        System.out.println(randomO1.getRandom());
    }

}
