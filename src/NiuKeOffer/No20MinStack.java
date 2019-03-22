package NiuKeOffer;

import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2019-03-17-20:45
 * @since 1.0.0
 */
public class No20MinStack {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(minData.empty()){
            minData.push(node);
        }else{
            minData.push(Math.min(minData.peek(),node));
        }
    }

    public void pop() {
        if(!minData.empty() && !data.empty()){
            minData.pop();
            data.pop();
        }

    }

    public int top() {
        if(!data.empty()){
            return data.peek();
        }
        return 0;
    }

    public int min() {
        if(!minData.empty()){
            return minData.peek();
        }
        return 0;
    }

}
