package Array;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * @author Mr.Bao
 * @create 2018-11-23-9:55
 * @since 1.0.0
 */
public class No695MaxAreaofIsLand {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new No695MaxAreaofIsLand().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max = Math.max(max,findMaxArea(grid,i,j));

                }
            }
        }
        return max;
    }

    public int findMaxArea(int[][] matrix,int i,int j){

        if(i<0 || i >=matrix.length || j <0 || j>=matrix[0].length || matrix[i][j]==0){
            return 0;
        }else if(matrix[i][j]==1){
            matrix[i][j] = 0; //为了避免往回走，把值设置成0
            int result = 1;
            result = result +  findMaxArea(matrix,i+1,j) +  findMaxArea(matrix,i,j+1);
            if(i-1>=0){
                result+=findMaxArea(matrix,i - 1,j);
            }
            if(j-1>=0){
                result+=findMaxArea(matrix,i ,j-1);
            }
            return result;
        }
        return 0;
    }
}
