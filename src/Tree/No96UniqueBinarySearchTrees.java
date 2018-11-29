package Tree;

/**
 * @author Mr.Bao
 * @create 2018-11-26-18:05
 * @since 1.0.0
 */
public class No96UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                nums[i] += nums[j-1] * nums[i - j];
            }
        }
        return nums[n];

    }

    public static void main(String[] args) {
        System.out.println(new No96UniqueBinarySearchTrees().numTrees(3));
    }


}
