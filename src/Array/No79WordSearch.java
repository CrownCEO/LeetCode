package Array;

/**使用dfs了遍历，dfs需要有个矩阵来记录路径，另外将是否遍历完字符串作为 递归的返回条件
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * @author Mr.Bao
 * @create 2018-10-25-21:59
 * @since 1.0.0
 */
public class No79WordSearch {

    public static void main(String[] args) {
        No79WordSearch search = new No79WordSearch();
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(search.exist(chars, "ABBCCED"));
        System.out.println(search.exist(chars, "SEE"));
        System.out.println(search.exist(chars, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        char words[] = word.toCharArray();
        char target = words[0];
        int[][] v = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == target){
                    if(dfs(board,words,i,j,0,v)){
                        return true;
                    }
                }
            }
        }


        return false;
    }

    public boolean dfs(char[][]board,char[] words,int i,int j,int index,int[][] v){
        int m = board.length;
        int n = board[0].length;
        if(index==words.length - 1){
            return true;
        }
        v[i][j] = 1;
        if(i-1>=0&&v[i-1][j]==0&&words[index+1]==board[i-1][j]){
            if(dfs(board,words,i-1,j,index+1,v)){
                return true;
            }
        }
        if(i+1<m&&v[i+1][j]==0&&words[index+1]==board[i+1][j]){
            if(dfs(board,words,i+1,j,index+1,v)){
                return true;
            }
        }
        if(j-1>=0&&v[i][j-1]==0&&words[index+1]==board[i][j-1]){
            if(dfs(board,words,i,j-1,index+1,v)){
                return true;
            }
        }
        if(j+1<n&&v[i][j+1]==0&&words[index+1]==board[i][j+1]){
            if(dfs(board,words,i,j+1,index+1,v)){
                return true;
            }
        }
        v[i][j] = 0;
        return false;
    }


}
