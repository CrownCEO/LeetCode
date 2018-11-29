package Tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 * @author Mr.Bao
 * @create 2018-11-26-17:36
 * @since 1.0.0
 */
public class No98ValidateBinarySearchTree {

    TreeNode pre = null;
    public boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }

    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        if(pre!=null){
            if(node.val <= pre.val){
                isValid = false;
            }
        }
        pre = node;
        inorder(node.right);
    }

}
