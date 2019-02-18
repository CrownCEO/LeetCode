package A_Offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 * 函数。在该栈中，调用min,push,pop的时间复杂度都是O(1)
 * 解法：
 * 需要定义一个辅助栈用来存储每次来数据时候的当前最小数据，如果新数据比
 * 辅助栈顶数据小，则将新数据加入到辅助栈中，否则，将辅助栈顶的数据再次加入到
 * 辅助栈中。
 * @author Mr.Bao
 * @create 2019-02-17-8:24
 * @since 1.0.0
 */
public class No21MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    public No21MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.empty() || min.peek() > x){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        if(!min.empty()){
            min.pop();
        }
        if(!data.empty()){
            data.pop();
        }
    }

    public int top() {
        if(!data.empty()){
            return data.peek();
        }
        return 0;
    }

    public int getMin() {
        if(!min.empty()){
            return min.peek();
        }
        return 0;
    }
}
