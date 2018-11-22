package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * @author Mr.Bao
 * @create 2018-11-08-9:57
 * @since 1.0.0
 */

public class No56MergeIntervals {

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();
        if(intervals==null || intervals.size()==0){
            return result;
        }
        if(intervals.size()==1){
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 0;i<intervals.size();i++){

            Interval interval = intervals.get(i);
            if(i==0){
                result.add(interval);
                continue;
            }
            Interval oldInterval = result.get(result.size() - 1);
            if(interval.start <= oldInterval.end){
                result.remove(result.size() - 1);
                if(interval.end <=oldInterval.end){
                    result.add(oldInterval);
                }else{
                    result.add(new Interval(oldInterval.start,interval.end));
                }

            }else{
                result.add(interval);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        No56MergeIntervals intervals = new No56MergeIntervals();
        List<No56MergeIntervals.Interval> intervals1 = new ArrayList<>();
        intervals1.add(new No56MergeIntervals.Interval(1,4));
        intervals1.add(new No56MergeIntervals.Interval(0,2));
        intervals1.add(new No56MergeIntervals.Interval(3,5));
        for(Interval interval:intervals.merge(intervals1)){
            System.out.println(interval.start + "" + interval.end);
        }
//        System.out.println(intervals.merge(intervals1));
    }
}
