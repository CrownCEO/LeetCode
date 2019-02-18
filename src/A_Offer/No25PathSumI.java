package A_Offer;

import common.TreeNode;

/**
 * 给定一个二叉树和一个数组，求是否有一条从根到叶子结点的路径和为给定的值。
 * 解法:
 * 遍历这颗树，每次处理的时候，用和减去当前结点的值，如果到了子树的叶子结点时（到叶子结点即该结点左子树和右子树为空），和为0，则存在这条路径。
 * @author Mr.Bao
 * @create 2019-02-17-21:04
 * @since 1.0.0
 */
public class No25PathSumI {


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return findPathSum(root,sum);
    }


    public boolean findPathSum(TreeNode treeNode, int sum){
        if(treeNode==null){
            return false;
        }
        sum = sum - treeNode.val;
        if(treeNode.right==null && treeNode.left==null && sum==0){
            return true;
        }
        return findPathSum(treeNode.left, sum) || findPathSum(treeNode.right, sum);
    }

}
