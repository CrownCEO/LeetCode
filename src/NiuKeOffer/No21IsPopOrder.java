package NiuKeOffer;

import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2019-03-21-21:59
 * @since 1.0.0
 */
public class No21IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || pushA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 0;i<popA.length;i++){
            while(stack.empty() || stack.peek()!=popA[i]){
                if(index >=pushA.length){
                    return false;
                }
                stack.push(pushA[index]);
                index++;
            }
            stack.pop();
        }
        if(!stack.empty()){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int b[] = {4,5,3,2,1};
        int c[] = {4,3,5,1,2};
        System.out.println(new No21IsPopOrder().IsPopOrder(a,b));
        System.out.println(new No21IsPopOrder().IsPopOrder(a,c));
    }

}
