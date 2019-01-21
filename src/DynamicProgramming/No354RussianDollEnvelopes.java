package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * @author Mr.Bao
 * @create 2019-01-07-19:45
 * @since 1.0.0
 */
public class No354RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0){
            return 0;
        }
        if(envelopes.length==1){
            return 1;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if( envelopes[j][0] <envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
            if(dp[i]==0){
                dp[i]=1;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new No354RussianDollEnvelopes().maxEnvelopes(nums));
    }
}
