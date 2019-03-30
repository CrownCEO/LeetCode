package NiuKeOffer;

import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-28-16:47
 * @since 1.0.0
 */
public class No36FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while(node1!=node2){
            if(node1==null){
                node1= pHead2;
            }else{
                node1 = node1.next;
            }
            if(node2==null){
                node2 = pHead1;
            }else{
                node2 = node2.next;
            }
        }
        return node1;
    }
}
