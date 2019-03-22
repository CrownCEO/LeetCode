package NiuKeOffer;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-17-20:24
 * @since 1.0.0
 */
public class No18Mirror {


    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        tree(root);
    }

    public void tree(TreeNode root){

        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            tree(root.left);
        }
        if(root.right!=null){
            tree(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
