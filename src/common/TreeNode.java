package common;

/**
 * @author Mr.Bao
 * @create 2018-11-26-17:36
 * @since 1.0.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public Integer val() {
        return val;
    }

    public TreeNode left() {
        return left;
    }

    public TreeNode right() {
        return right;
    }

    @Override
    public String toString() {
        return val + " " + left.val +" "+ right.val;
    }
}
