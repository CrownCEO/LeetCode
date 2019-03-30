package NiuKeOffer;

import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-30-15:32
 * @since 1.0.0
 */
public class No55deleteDuplication {


    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode node = pHead;
        ListNode previous = first;
        while(node!=null&&node.next!=null){
            if(node.val==node.next.val){
                while(node.next!=null && node.val==node.next.val){
                    node = node.next;
                }
                previous.next = node.next;
            }else{
                previous = node;
            }
            node = node.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new No55deleteDuplication().deleteDuplication(root));
    }

}
