package TopologicalSort;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * @author Mr.Bao
 * @create 2018-10-20-19:35
 * @since 1.0.0
 */
public class No210CourseScheduleII {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] map=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            map[prerequisites[i][0]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<map.length;i++){
            if(map[i]==0) {
                stack.push(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        int count = stack.size();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            res.add(temp);
            for(int i=0;i<prerequisites.length;i++){
                if(temp== prerequisites[i][1]){
                    int t  = prerequisites[i][0];
                    map[t]--;
                    if(map[t]==0){
                        stack.push(t);
                        count++;
                    }
                }
            }
        }
        if(count!=numCourses){
            int[] a = new int[0];
            return a;
        }else {
            int[] a = new int[res.size()];
            for(int i=0;i<res.size();i++){
                a[i] = res.get(i);
            }
            return a;
        }
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        No210CourseScheduleII courseScheduleII = new No210CourseScheduleII();
        int[] result = courseScheduleII.findOrder(4,nums);
        for(int temp:result){
            System.out.println(temp);
        }
    }

}
