package A_Offer;

import common.TreeNode;

/**leetcode 426 付费题
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建 任何新的结点，只能调整树中结点的指向。
 * 解法：
 * 将一颗二叉搜索树转换成排序的双向链表，对树进行中序遍历，因为树的中序遍历是 左根右，刚好按照排序的顺序来遍历，递归遍历的函数
 * 要传递一个 前向指针，每次在遍历到结点的时候，将当前结点的左指针指向前向结点，将前向指针的右结点指向当前指针，将前向指针赋值为当前结点
 * 最后需要返回头结点，通过前向结点一直往前，即访问结点的左结点。就可以得到头结点。
 * @author Mr.Bao
 * @create 2019-02-20-12:04
 * @since 1.0.0
 */
public class No27ConvertBinarySearchTreetoSortedDoublyLinkedList {

    public TreeNode convert(TreeNode treeNode){

        if(treeNode==null){
            return null;
        }
        TreeNode lastNode = null;
        TreeNode head = lastNode;
        convertNode(treeNode,lastNode);
        while(head!=null && head.left!=null){
            head = head.left;
        }
        return head;
    }

    public void convertNode(TreeNode node,TreeNode lastNode){
        if(node==null){
            return;
        }

        if(node.left!=null){
            convertNode(node.left,lastNode);
        }
        TreeNode current = node;
        current.left = lastNode;
        if(lastNode!=null){
            lastNode.right = current;
        }
        node = current;

        if(node.right!=null){
            convertNode(node.right,lastNode);
        }
    }
}
