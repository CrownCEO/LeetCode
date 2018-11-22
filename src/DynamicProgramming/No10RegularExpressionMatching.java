package DynamicProgramming;

/**
 * 感觉不太会 还得多看看   问题主要是 出在碰到 * 的时候
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * @author Mr.Bao
 * @create 2018-11-01-20:16
 * @since 1.0.0
 */
public class No10RegularExpressionMatching {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }


    public static void main(String[] args) {
        No10RegularExpressionMatching matching = new No10RegularExpressionMatching();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(matching.isMatch(s,p));
    }
}
