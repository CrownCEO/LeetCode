package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-12-22:26
 * @since 1.0.0
 */
public class No1Search2DMatrix {

    public boolean Find(int target, int [][] array) {
        if(array==null || array.length==0){
            return false;
        }
        int n = array.length;
        int m = array[0].length;
        int row = 0;
        int col = m - 1;
        while(row<n && col>=0){
            int num = array[row][col];
            if(target<num){
                col = col - 1;
            }else if(target>num){
                row = row + 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new No1Search2DMatrix().Find(1,matrix));
    }

}
