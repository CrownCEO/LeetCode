package Geometry;

import java.util.*;

/**
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
 *
 * @author Mr.Bao
 * @create 2018-10-15-22:06
 * @since 1.0.0
 */

class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}
public class No587ErectTheFence {


    public List<Point> outerTrees(Point[] points) {
        List<Point> res = new ArrayList<>();
        Point first = points[0];
        int firstIdx = 0;
        int n = points.length;
        for(int i = 1;i<n;i++){
            if(points[i].x < first.x){
                first = points[i];
                firstIdx = i;
            }
        }
        res.add(first);
        Point cur = first;
        int cuIdx = firstIdx;
        while(true){
            Point next = points[0];
            int nextIdx = 0;
            for(int i = 1;i<n;i++){
                if(i == cuIdx){
                    continue;
                }
                int cross = crossProduct(cur,points[i],next);
                if(nextIdx == cuIdx || cross > 0|| (cross == 0) && dist(points[i],cur) > dist(next,cur)){
                    next = points[i];
                    nextIdx = i;
                }
            }
            for(int i = 0;i<n;i++){
                if(i == cuIdx){
                    continue;
                }
                int cross = crossProduct(cur,points[i], next);
                if(cross==0){
                    if(check(res,points[i])){
                        res.add(points[i]);
                    }
                }
            }
            cur = next;
            cuIdx = nextIdx;
            if (cuIdx==firstIdx){
                break;
            }
        }

        return res;


    }



    public int  crossProduct(Point A,Point B,Point C){
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;
        return BAx * BCy - BAy * BCx;
    }

    int dist(Point A, Point B){
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
    }

     boolean check(List<Point> list, Point p){
        for(Point point:list){
            if(point.x == p.x && point.y == p.y){
                return  false;
            }
        }
        return true;
     }

}
