package DynamicProgramming;

import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2018-12-03-9:36
 * @since 1.0.0
 */
public class No32LongestValidParentheses {

    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "()(())";
        System.out.println(new No32LongestValidParentheses().longestValidParentheses2(s3));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int lastValidIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.empty()) {
                    lastValidIndex = i + 1;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        maxLength = Math.max(maxLength, i - lastValidIndex + 1);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.pop());
                    }
                }
            }
        }

        return maxLength;
    }

    /**f[i] 存储的是 以当前括号为结尾的 合法括号的个数
     * 分情况讨论
     * 从左往右遍历 当碰到左括号时，为0
     * 当碰到右括号时 先观察i- f[i - 1] - 1的位置上是左括号的话才处理 这样是因为有这样的情况）（）（））
     *      当前位置减一的位置的值 + 2,然后判定需不需要加上i- f[i - 1] - 1 - 1位置的值。这样做是因为有这样的情况（）（（）（））
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int ret = 0;
        int f[] = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; ++i) {
            f[i] = 0;
            if (s.charAt(i)== '(') {
                f[i] = 0;
            } else {
                int idx = i - f[i-1] - 1;
                if (idx >= 0 && s.charAt(idx) == '(') {  // detect "...((..))"
                    f[i] = f[i-1] + 2;
                    if (idx - 1 >= 0) f[i] += f[idx-1];
                }
            }
            ret = Math.max(ret, f[i]);
        }

        return ret;

    }
}
