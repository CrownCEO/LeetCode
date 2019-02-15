package A_Offer;

import common.ListNode;

/**
 * 给定一个链表，删除倒数第n个结点
 * 解法：
 * 定义两个指针，一般来讲我们新定义一个指针存储 0 来作为头节点。用此结点来初始化两个指针，
 *这样做的话，在循环中判断是否为null 使用的是 结点本身，而不是结点的next
 * @author Mr.Bao
 * @create 2019-02-15-17:11
 * @since 1.0.0
 */
public class No15RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null || n ==0){
            head=null;
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstNode = dummy;
        ListNode secondNode = dummy;

        for(int i = 1;i<=n+1;i++){
            firstNode = firstNode.next;
        }

        while(firstNode!=null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new No15RemoveNthNodeFromEndofList().removeNthFromEnd(head,2));
    }
}
