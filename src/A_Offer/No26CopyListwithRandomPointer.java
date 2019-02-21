package A_Offer;

import common.RandomListNode;

import java.util.Random;

/**leetcode 138
 * 给定一个链表，链表中的每个结点包含一个额外的随机指针，指向链表中任何一个结点，或者null
 *返回这个链表的深拷贝
 * 解法：
 * 链表的复制 一共可以分三步
 * 第一步：在所有的结点后面链接一个值和前面结点值一样的结点。
 * 第二步：给每个复制结点的random 结点赋值，值就等于复制结点前面几点的random 结点的下一个结点的值
 * 第三步：将这个大链表拆开。
 *
 * 这个题的难点在于 不好确定复制结点的random结点的位置。通过上面这种方式就能方便的确定random结点的位置。
 * @author Mr.Bao
 * @create 2019-02-18-11:52
 * @since 1.0.0
 */
public class No26CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        copyBaseNode(head);
        copyRandomNode(head);
        return copySuccess(head);
    }

    public void copyBaseNode(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            RandomListNode copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            copyNode.random = null;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    public void copyRandomNode(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            RandomListNode copyNode = node.next;
            if(node.random!=null){
                copyNode.random = node.random.next;
            }
            node = copyNode.next;
        }
    }

    public RandomListNode copySuccess(RandomListNode head){
        RandomListNode copyHead = null;
        RandomListNode copyNode = null;
        RandomListNode node = head;
        if(node!=null){
            copyHead = copyNode = node.next;
            node.next = copyHead.next;
            node = node.next;
        }
        while(node!=null){
            copyNode.next = node.next;
            copyNode = copyNode.next;
            node.next = copyNode.next;
            node = node.next;

        }
        return copyHead;
    }
}
