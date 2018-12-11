package DynamicProgramming;

/**
 * @author Mr.Bao
 * @create 2018-12-07-21:41
 * @since 1.0.0
 */
public class No97InterleavingString {


    public boolean isInterleave (String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1;i<=m;i++){
            dp[i][0] = dp[i-1][0] && (s3.charAt(i-1) == s1.charAt(i - 1));
        }
        for(int i = 1;i<=n;i++){
            dp[0][i] = dp[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = dp[i][j - 1] &&(s2.charAt(j - 1)==s3.charAt(i+j-1)) ||
                        dp[i-1][j] &&(s1.charAt(i - 1) == s3.charAt(i+j-1));
            }
        }
        return dp[m][n];

    }


    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new No97InterleavingString().isInterleave(s1, s2, s3));
        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        System.out.println(new No97InterleavingString().isInterleave(s1, s2, s3));
    }
}
