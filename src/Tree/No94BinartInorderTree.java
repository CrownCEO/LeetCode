package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * @author Mr.Bao
 * @create 2018-11-26-17:46
 * @since 1.0.0
 */
public class No94BinartInorderTree {

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }
}
