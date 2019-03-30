package NiuKeOffer;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-28-21:51
 * @since 1.0.0
 */
public class No38TreeDepth {

    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1 + Math.max(left,right);
    }

}
