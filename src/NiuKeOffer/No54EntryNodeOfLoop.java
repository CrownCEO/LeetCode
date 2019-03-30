package NiuKeOffer;

import common.ListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-30-15:13
 * @since 1.0.0
 */
public class No54EntryNodeOfLoop {


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode p1 = pHead.next;
        if(p1==null){
            return null;
        }
        ListNode p2 = p1.next;
        while(p1!=null && p2!=null){

            if(p1==p2){
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p2!=null){
                p2 = p2.next;
            }
        }
        if(p1!=p2){
            return null;
        }
        p2 = pHead;
        while(p1!=null &&p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
