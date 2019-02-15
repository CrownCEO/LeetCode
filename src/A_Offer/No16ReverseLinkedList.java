package A_Offer;

import common.ListNode;

/**
 * 定义一个函数，输入这个链表的头结点，反转链表，返回头节点。
 * 解法1：
 * 定义一个头指针，用来保存反转以后的链表头。然后定义first 指针，初始化为head.
 * 定义second 指针初始化为first指针的下一个。
 * reverseNode = null
 * while(first!=null)
 * second = first.next
 * first.next = reverseNode
 * reverseNode = first
 * first = second
 *
 * @author Mr.Bao
 * @create 2019-02-15-18:23
 * @since 1.0.0
 */
public class No16ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode first = head;
        ListNode reverseHead = null;
        while(first!=null){
            ListNode second = first.next;
            first.next = reverseHead;
            reverseHead = first;
            first = second;
        }


        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new No16ReverseLinkedList().reverseList(head));
    }
}
