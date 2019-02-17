package A_Offer;

import common.ListNode;

/**
 * 合并两个有序链表
 * 解法：
 * 使用递归的方式，先定义一个合并以后的头，如果链表1的头节点小于链表2的头节点，则合并后的
 * 头结点是链表的头结点，然后递归链表1的一个结点和链表2，如果链表1的头结点大于等于链表2的头节点，则合并后
 * 的头结点是链表2的头结点，然后递归链表1和链表2剩余
 * @author Mr.Bao
 * @create 2019-02-16-8:58
 * @since 1.0.0
 */
public class No17MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode mergeHead = null;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next,l2);
        }else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1,l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        System.out.println(new No17MergeTwoSortedLists().mergeTwoLists(head1,head2));
        System.out.println("end");

    }
}
