package DynamicProgramming;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * @author Mr.Bao
 * @create 2018-12-07-22:01
 * @since 1.0.0
 */
public class No115DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] += dp[i-1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
       String  S = "babgbag", T = "bag";
       System.out.println(new No115DistinctSubsequences().numDistinct(S,T));
    }
}
