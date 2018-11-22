package Array;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * @author Mr.Bao
 * @create 2018-10-29-21:38
 * @since 1.0.0
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class No105ConstructBinaryTreefromPredorandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode rootNode = new TreeNode(preorder[0]);
        return  rootNode;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        No105ConstructBinaryTreefromPredorandInorderTraversal traversal = new No105ConstructBinaryTreefromPredorandInorderTraversal();
        System.out.println(traversal.buildTree(preorder,inorder));
    }

}
