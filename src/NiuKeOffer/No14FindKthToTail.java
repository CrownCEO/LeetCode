package NiuKeOffer;

import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-17-12:05
 * @since 1.0.0
 */
public class No14FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(head ==null || k==0){
            return null;
        }
        ListNode firstNode = null;
        ListNode secondNode = head;
        for(int i = 0;i< k - 1;i++){
            if(secondNode.next!=null){
                secondNode = secondNode.next;
            }else{
                return null;
            }
        }
        firstNode = head;
        while(secondNode.next!=null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(new No14FindKthToTail().FindKthToTail(head,1).val);

    }

}
