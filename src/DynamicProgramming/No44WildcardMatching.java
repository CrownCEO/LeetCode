package DynamicProgramming;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).
 * @author Mr.Bao
 * @create 2018-11-01-21:42
 * @since 1.0.0
 */
public class No44WildcardMatching {
    public boolean isMatch(String s, String p) {
        /**
         * 这是看到论坛上的人用DP的思想实现的
         * 本人没有实现，用递归写虽然正确，但是TLE
         * 这一题我也没有彻底看懂本代码，只能先写到这里，以后再来学习
         */
        int m = s.length(), n = p.length();
        int count = 0;//*的个数
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*')
                count++;//统计*的个数
        }
        if (count==0 && m != n)
            return false;//如果没有*且m!=n，肯定不匹配
        else if (n - count > m)
            return false;//如果不是*的个数>m，则相等于没有*还是大于m，不匹配

        boolean[] match = new boolean[m+1];//默认全为false
        match[0] = true;//第一个设为true
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {//如果为*，则s对应的之后所有数据默认匹配
                for (int j = 0; j < m; j++) {
                    match[j+1] = match[j] || match[j+1];
                }
            } else {//如果不为*，则用最后一位匹配
                for (int j = m-1; j >= 0; j--) {
                    match[j+1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];
    }

    public static void main(String[] args) {
        No44WildcardMatching matching = new No44WildcardMatching();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(matching.isMatch(s,p));
    }

}
