package NiuKeOffer;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2019-03-12-22:51
 * @since 1.0.0
 */
public class No3PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null){
            return  new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new No3PrintListFromTailToHead().printListFromTailToHead(head));
    }

}
