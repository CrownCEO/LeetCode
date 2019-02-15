package A_Offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 解法：
 * 插入：永远插入到第一个栈中
 * 删除：如果第二个栈为空，将栈1中的数据弹出插入到第二个栈中，如果第二个栈不为空，直接弹出
 * @author Mr.Bao
 * @create 2019-02-14-14:34
 * @since 1.0.0
 */
public class No7ImplementQueueusingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public No7ImplementQueueusingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return  stack1.empty() && stack2.empty();
    }

}
