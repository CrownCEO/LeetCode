package Geometry;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.

 Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

 Return the total surface area of the resulting shapes.
 *
 * @author Mr.Bao
 * @create 2018-10-17-9:51
 * @since 1.0.0
 */
public class No892SurfaceAreaof3DShapes {

    public int surfaceArea(int[][] grid) {

        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    continue;
                }
                result =result +  grid[i][j] * 4 + 2;
                if(i - 1>=0){
                    result = result - Math.min(grid[i][j],grid[i-1][j]) * 2;
                }
                if(j - 1>=0){
                    result = result - Math.min(grid[i][j], grid[i][j-1]) * 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No892SurfaceAreaof3DShapes shapes = new No892SurfaceAreaof3DShapes();
        int[][] grid = new int[][]{{2}};
        System.out.println(shapes.surfaceArea(grid));
    }

}
