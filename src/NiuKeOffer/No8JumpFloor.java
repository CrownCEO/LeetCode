package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-13-23:25
 * @since 1.0.0
 */
public class No8JumpFloor {

    public int JumpFloor(int target) {
        if(target==1 || target==2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new No8JumpFloor().JumpFloor(3));
    }
}
