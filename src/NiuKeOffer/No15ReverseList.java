package NiuKeOffer;

import A_Offer.No15RemoveNthNodeFromEndofList;
import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-17-18:02
 * @since 1.0.0
 */
public class No15ReverseList {

    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode preNode = new ListNode(head.val);
        ListNode currentNode = head.next;
        while(currentNode!=null){
            ListNode temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(new No15ReverseList().ReverseList(head).val);
    }

}
