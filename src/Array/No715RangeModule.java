package Array;

import java.util.Map;
import java.util.TreeMap;

/**
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

 addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
 removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
 * @author Mr.Bao
 * @create 2018-12-01-10:25
 * @since 1.0.0
 */
public class No715RangeModule {

    TreeMap<Integer, int[]> map = new TreeMap<>();

    public No715RangeModule() {

    }

    public void addRange(int left, int right) {
        if(map.containsKey(left)){
            int[] cur = map.get(left);
            cur[1] = Math.max(cur[1], right);
            Map.Entry<Integer, int[]> higherEntry = map.higherEntry(cur[0]);
            while(higherEntry!=null){
                if(higherEntry.getKey() > cur[1]) {
                    break;
                }
                map.remove(higherEntry.getKey());
                cur[1] = Math.max(cur[1], higherEntry.getValue()[1]);
                higherEntry = map.higherEntry(higherEntry.getKey());
            }
        }else{
            int[] cur = new int[]{left,right};
            Map.Entry<Integer, int[]> lowerEntry = map.lowerEntry(cur[0]);
            if(lowerEntry !=null && lowerEntry.getValue()[1] >= cur[0]){
                map.remove(lowerEntry.getKey());
                cur[0] = Math.min(cur[0], lowerEntry.getValue()[0]);
                cur[1] = Math.max(cur[1], lowerEntry.getValue()[1]);
            }

            Map.Entry<Integer,int[]> higherEntry = map.higherEntry(cur[0]);
            while(higherEntry !=null){
                if(higherEntry.getKey() > cur[1]) {
                    break;
                }
                map.remove(higherEntry.getKey());
                cur[1] = Math.max(cur[1], higherEntry.getValue()[1]);
                higherEntry = map.higherEntry(higherEntry.getKey());
            }
            map.put(cur[0], cur);
        }

    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, int[]> floorEntry = map.floorEntry(left);
        return floorEntry != null && floorEntry.getValue()[1] >=right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, int[]> floorEntry = map.floorEntry(left);
        if(floorEntry !=null){
            if(floorEntry.getValue()[1] > right){
                map.put(right, new int[]{right, floorEntry.getValue()[1]});
            }
            floorEntry.getValue()[1] = Math.min(floorEntry.getValue()[1], left);
        }

        Map.Entry<Integer, int[]> higherEntry = map.higherEntry(left);
        int[] cur = higherEntry ==null ? null : higherEntry.getValue();
        while(cur !=null){
            if(cur[0] >= right){
                break;
            }
            map.remove(cur[0]);
            if(cur[1] >= right){
                cur[0] = right;
                map.put(cur[0], cur);
                break;
            }else{
                higherEntry = map.higherEntry(higherEntry.getKey());
                cur = higherEntry ==null ? null : higherEntry.getValue();
            }
        }
    }
}
