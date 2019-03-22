package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-17-10:32
 * @since 1.0.0
 */
public class No10RectCover {

    public int RectCover(int target) {

        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=target;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

}
