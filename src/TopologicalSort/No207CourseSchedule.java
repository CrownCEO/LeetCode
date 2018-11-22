package TopologicalSort;

import java.util.LinkedList;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * DFS的执行速度没有BFS 执行速度快
 *
 * @author Mr.Bao
 * @create 2018-10-17-20:53
 * @since 1.0.0
 */
public class No207CourseSchedule {

    static Stack<Integer> stack = new Stack<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        int[][] matrix = new int[numCourses][numCourses];

        for(int i = 0;i<prerequisites.length;i++){
            int[] temp = prerequisites[i];
            matrix[temp[0]][temp[1]] = 1;
        }
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    indegree[j] = indegree[j] + 1;
                }
            }
        }
       return  DFS(numCourses,matrix,indegree);
    }

    public boolean BFS( int numCourses, int[][] matrix, int indegree[]){
        int count = 0;
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                stack.push(i);
                indegree[i]=-1;
            }
        }
        while(!stack.empty()){
            int result = stack.pop();
            count++;
            for(int j = 0;j<numCourses;j++){
                if(matrix[result][j]==1){
                    matrix[result][j]=0;
                    indegree[j] = indegree[j] - 1;
                    if(indegree[j]==0){
                        stack.push(j);
                        indegree[j]=-1;
                    }
                }
            }
        }
        if(count<numCourses){
            return false;
        }else{
            return true;
        }
    }

    public boolean DFS( int numCourses, int[][] matrix, int indegree[]){
        int count = 0;
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                stack.push(i);
                indegree[i]=-1;
            }
            while(!stack.empty()){
                int result = stack.pop();
                count++;
                for(int j=0;j<numCourses;j++){
                    if(matrix[result][j]==1){
                        matrix[result][j]=0;
                        indegree[j]--;
                        if(indegree[j]==0){
                            stack.push(j);
                            indegree[j]=-1;
                        }
                    }
                }

            }
        }
        if(count<numCourses){
            return false;
        }else{
            return true;
        }

    }


}
