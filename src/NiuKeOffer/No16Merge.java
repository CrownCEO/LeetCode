package NiuKeOffer;

import A_Offer.No16ReverseLinkedList;
import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-17-18:33
 * @since 1.0.0
 */
public class No16Merge {

    public ListNode Merge(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode mergeHead = null;
        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);
        }else{
            mergeHead = list2;
            mergeHead.next = Merge(list1,list2.next);
        }

        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        System.out.println(new No16Merge().Merge(head1,head2));
    }
}
