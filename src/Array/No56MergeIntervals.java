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
        List<Interval> res = new ArrayList<>();
        if(intervals.size()<1){
            return res;
        }

        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval i1,Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval temp = null;
        for(Interval interval:intervals){
            if(temp == null || temp.end<interval.start){
                res.add(interval);
                temp = interval;
            }else {
                temp.end = Math.max(temp.end,interval.end);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No56MergeIntervals intervals = new No56MergeIntervals();
        List<No56MergeIntervals.Interval> intervals1 = new ArrayList<>();
        intervals1.add(new No56MergeIntervals.Interval(1,3));
        intervals1.add(new No56MergeIntervals.Interval(2,6));
        intervals1.add(new No56MergeIntervals.Interval(8,10));
        for(Interval interval:intervals.merge(intervals1)){
            System.out.println("[" + interval.start + " " + interval.end + "]");
        }
//        System.out.println(intervals.merge(intervals1));
    }
}
