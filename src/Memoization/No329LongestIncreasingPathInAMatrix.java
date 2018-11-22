package Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an integer matrix, find the length of the longest increasing path.  From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * @author Mr.Bao
 * @create 2018-10-10-19:22
 * @since 1.0.0
 */
class No329LongestIncreasingPathInAMatrix {

    private int dfs(int[][] matrix,int[][] memory,int i, int j,int lastVal){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length){
            return 0;
        }
        if(matrix[i][j]>lastVal){
            if( memory[i][j]!=0){
                return memory[i][j];
            }
            int top = dfs(matrix,memory,i-1,j,matrix[i][j]) + 1;
            int bottom = dfs(matrix,memory,i+1,j,matrix[i][j]) + 1;
            int left = dfs(matrix,memory,i,j-1,matrix[i][j]) +1;
            int right = dfs(matrix,memory,i,j+1,matrix[i][j]) + 1;
            memory[i][j] = Math.max(top,Math.max(bottom,Math.max(left,right)));
            return   memory[i][j];
        }
        return 0;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int longest = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                longest = Math.max(longest,dfs(matrix,memory,i,j,-1));
            }
        }
        return longest;

    }
}
