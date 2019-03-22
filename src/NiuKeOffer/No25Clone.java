package NiuKeOffer;

import common.RandomListNode;

/**
 * @author Mr.Bao
 * @create 2019-03-21-23:04
 * @since 1.0.0
 */
public class No25Clone {

    public RandomListNode Clone(RandomListNode pHead)
    {
        pHead = copy(pHead);
        pHead = copyRandom(pHead);
        return pHead;
    }

    public RandomListNode copy(RandomListNode pHead){
        if(pHead==null){
            return new RandomListNode(0);
        }
        RandomListNode node = pHead;
        while(node!=null){
            RandomListNode temp = node.next;
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = temp;
            node.next = copy;
            node = temp;
        }
        return pHead;
    }

    public RandomListNode copyRandom(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node!=null){
            if(node.next!=null){
                node.next.random = node.random.next;
                node = node.next.next;
            }

        }
        return pHead;
    }

    public static void main(String[] args) {
        No25Clone clone = new No25Clone();
        RandomListNode randomListNode = new RandomListNode(1);
        randomListNode.next = new RandomListNode(2);
        randomListNode.next.next = new RandomListNode(3);
        randomListNode.random = randomListNode.next.next;
        randomListNode.next.random  = randomListNode;
        RandomListNode node1 = clone.Clone(randomListNode);
        System.out.println(node1);
    }
}
