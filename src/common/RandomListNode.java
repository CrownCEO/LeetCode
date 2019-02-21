package common;

/**
 * @author Mr.Bao
 * @create 2019-02-18-11:54
 * @since 1.0.0
 */
public class RandomListNode {

    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }

    public Integer label() {
        return label;
    }

    public RandomListNode next() {
        return next;
    }

    public RandomListNode random() {
        return random;
    }
}
