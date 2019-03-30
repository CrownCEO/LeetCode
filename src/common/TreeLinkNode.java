package common;

/**
 * @author Mr.Bao
 * @create 2019-03-30-16:05
 * @since 1.0.0
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int x) {
        val = x;
    }

    public Integer val() {
        return val;
    }

    public TreeLinkNode left() {
        return left;
    }

    public TreeLinkNode right() {
        return right;
    }

}
