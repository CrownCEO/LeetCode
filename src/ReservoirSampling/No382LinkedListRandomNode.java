package ReservoirSampling;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * @author Mr.Bao
 * @create 2018-10-10-21:47
 * @since 1.0.0
 */



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class No382LinkedListRandomNode {

    ListNode head = null;


    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public No382LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        int result = -1;
        ListNode temp = head;

        while((temp!=null)){
            count = count + 1;
            double r = Math.random();
            if(r < 1.0 / count){
                result = temp.val;
            }
            temp = temp.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */