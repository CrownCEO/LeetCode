package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * @author Mr.Bao
 * @create 2018-11-05-21:25
 * @since 1.0.0
 */
public class No51NQueens {

    public List<List<String>> solveNQueens(int n) {
        int[][] matrix = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        choose(result,cur,n,0);
        return result;
    }

    public void choose(List<List<String>> result,List<String> cur,int n,int level){

//        if(cur.size()==n){
//            return;
//        }
//
//        for(int i = 0;i<n;i++){
//            s.
//        }
//
//        choose(result,cur, level+ 1);


    }

    private boolean isValid(int[] queenList, int row, int col){

        for(int i = 0;i<row;i++){
            int pos = queenList[i];
            if(pos == col){
                return false;
            }
            if(pos + row - i == col){
                return false;
            }
            if(pos - row + i == col){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int n = 4;
        No51NQueens queens = new No51NQueens();
        System.out.println(queens.solveNQueens(n));
    }
}
