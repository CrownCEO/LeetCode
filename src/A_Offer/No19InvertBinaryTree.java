package A_Offer;

import common.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 解法：
 * 使用先序遍历 遍历整个二叉树，每次在根结点的时候，交换左右子结点。然后递归左子树和右子树。
 * @author Mr.Bao
 * @create 2019-02-16-17:09
 * @since 1.0.0
 */
public class No19InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp;
        temp= root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }
    }
}
