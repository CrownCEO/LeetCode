package NiuKeOffer;

import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2019-03-13-22:21
 * @since 1.0.0
 */
public class No5UseStackConstructQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public static void main(String[] args) {

    }

}
