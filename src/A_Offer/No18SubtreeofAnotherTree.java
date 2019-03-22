package A_Offer;

import common.TreeNode;

/**
 * 给两个非空二叉树，检查第一个树是否包含 第二个树，即判断第二个树是不是第一个树的子结构。
 * 解法：
 * 采用递归的方式来遍历二叉树，当两个结点的值相同时，进入 另一个函数去递归判断子结构是否相同。
 * 如果判断不相同，则继续递归遍历。找寻下一个结点时，是否子结构相同。
 * @author Mr.Bao
 * @create 2019-02-16-9:18
 * @since 1.0.0】
 *
 */
public class No18SubtreeofAnotherTree {

    public boolean HasSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if(s!=null && t!=null){
            if(s.val == t.val){
                result = hasSubTree(s,t);
            }
            if(!result){
                result = HasSubtree(s.left,t);
            }
            if(!result){
                result = HasSubtree(s.right,t);
            }
        }
        return result;

    }

    /**
     * 当两个树都为空的时候，说明都递归遍历到子节点，且值相同，因为如果值不同，就已经被返回false了。
     * 然后递归比较两个树的左子树和右子树
     * @param s
     * @param t
     * @return
     */
    public boolean hasSubTree(TreeNode s, TreeNode t){
        if(t==null){
            return true;
        }
        if(s==null){
            return  false;
        }
        if(s.val!=t.val){
            return false;
        }
        return hasSubTree(s.left,t.left) && hasSubTree(s.right,t.right);
    }
}
