package Tree;


import common.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.
 * @author Mr.Bao
 * @create 2018-11-26-17:40
 * @since 1.0.0
 */
public class No99RecoverBinarySearchTree {

    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(first,second);
    }

    public void swap(TreeNode a,TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void inorder(TreeNode node){
        if(node==null){
            return ;
        }
        inorder(node.left);
        if(pre!=null){
            if(first==null && node.val < pre.val){
                first = pre;
            }
            if(first!=null && node.val < pre.val){
                second = node;
            }
        }
        pre = node;
        inorder(node.right);
    }

}
