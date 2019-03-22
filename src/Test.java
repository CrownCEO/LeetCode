import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2019-02-28-19:07
 * @since 1.0.0
 */
public class Test {

    int count = 0;
    Stack<Integer> stack = new Stack<>();

    public int pailie(int num1, int num2) {
        p(0, 0, 4, 8);
        return 0;
    }

    public void p(int curNum, int curMax, int num1, int num2) {
        if (curNum == num1) {
            System.out.println(stack);
        }
        for (int i = curMax + 1; i <= num2; i++) {
            stack.push(i);
            p(curNum + 1, i, num1, num2);
            stack.pop();
        }
    }

    public static void main(String[] args) {
//        new Test().pailie(4,8);

    }
}
