package NiuKeOffer;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-28-21:56
 * @since 1.0.0
 */
public class No39IsBalanced_Solution {

    class Holder{
        public int depth;

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        return isbalanced(root,new Holder());
    }

    public boolean isbalanced(TreeNode root,Holder depth){
        if(root==null){
            depth.depth = 0;
            return true;
        }
        Holder left = new Holder();
        Holder right = new Holder();
        if(isbalanced(root.left,left) && isbalanced(root.right,right)){
            int dif = left.depth - right.depth;
            if(dif >=-1 && dif <=1){
                depth.depth= 1 + Math.max(left.depth,right.depth);
                return true;
            }
        }
        return false;
    }
}
