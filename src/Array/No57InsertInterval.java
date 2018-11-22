package Array;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.
 * @author Mr.Bao
 * @create 2018-11-08-9:43
 * @since 1.0.0
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class No57InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        intervals.add(newInterval);

        return merge(intervals);
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
            public int compare(Interval o1,Interval o2) {
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
        No57InsertInterval insertInterval = new No57InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        System.out.println(insertInterval.insert(intervals,new Interval(2,5)));
    }

}

