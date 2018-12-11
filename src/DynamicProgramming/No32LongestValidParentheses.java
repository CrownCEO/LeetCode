package DynamicProgramming;

import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2018-12-03-9:36
 * @since 1.0.0
 */
public class No32LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int lastValidIndex = 0;
        for(int i = 0;i<chars.length;i++){
            if(chars[i] == '('){
                stack.push(i);
            }else if (chars[i] == ')'){
                if(stack.empty()){
                    lastValidIndex = i + 1;
                }else{
                    stack.pop();
                    if(stack.empty()){
                        maxLength = Math.max(maxLength, i - lastValidIndex + 1);
                    }else{
                        maxLength = Math.max(maxLength, i - stack.pop());
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";
        System.out.println(new No32LongestValidParentheses().longestValidParentheses(s2));
    }
}
