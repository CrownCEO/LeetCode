package NiuKeOffer;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-30-16:29
 * @since 1.0.0
 */
public class No57isSymmetrical {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    public boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return left.val==right.val && isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
    }

}
