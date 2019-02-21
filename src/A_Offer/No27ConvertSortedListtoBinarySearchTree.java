package A_Offer;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**leetcode 109
 * 给定一个有序链表，将其转换成为二叉搜索树
 * 解法：
 * 在中序二叉遍历的递归方式来构建 二叉树，函数传递的为 存放结点的的list，起始和结束索引。
 * 每次取出list的第一个结点作为 二叉树的根结点。然后递归赋值其 左结点和右结点。然后将list的第一个结点
 * 设置为第一个结点的下一个结点。
 * @author Mr.Bao
 * @create 2019-02-20-17:36
 * @since 1.0.0
 */
public class No27ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head;
        int count = 0;
        while(cur!=null)
        {
            cur = cur.next;
            count++;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        return helper(list,0,count-1);
    }
    private TreeNode helper(ArrayList<ListNode> list, int l, int r)
    {
        if(l>r)
            return null;
        int m = (l+r)/2;
        TreeNode left = helper(list,l,m-1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0,list.get(0).next);
        root.right = helper(list,m+1,r);
        return root;
    }
}
