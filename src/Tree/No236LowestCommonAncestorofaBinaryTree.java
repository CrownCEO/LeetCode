package Tree;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-15-23:31
 * @since 1.0.0
 */
public class No236LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root ==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new No236LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(root,root.left,root.left).val);
    }
}
