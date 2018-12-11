package DynamicProgramming;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/Dylan-Java-NYC/p/4824971.html
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * @author Mr.Bao
 * @create 2018-12-06-21:50
 * @since 1.0.0
 */
public class No95UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n<1){
            return res;
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<>();
        if(left < right){
            res.add(null);
            return res;
        }
        for(int i = left;i<=right;i++){
            List<TreeNode> leftRes = helper(left,i - 1);
            List<TreeNode> rightRes = helper(i+1, right);
            for(int m = 0;m < leftRes.size();m++){
                for(int n = 0;n<rightRes.size();n++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRes.get(m);
                    root.right = rightRes.get(n);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
