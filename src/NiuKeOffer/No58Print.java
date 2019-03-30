package NiuKeOffer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Mr.Bao
 * @create 2019-03-30-16:38
 * @since 1.0.0
 */
public class No58Print {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(null);
        linkedList.addLast(pRoot);;
        boolean leftToRight = true;
        while(linkedList.size()!=1){
            TreeNode node = linkedList.removeFirst();
            if(node==null){
                Iterator<TreeNode> iter = null;
                if(leftToRight){
                    iter = linkedList.iterator();
                }else{
                    iter = linkedList.descendingIterator();
                }
                leftToRight = !leftToRight;
                while(iter.hasNext()){
                    TreeNode temp = iter.next();
                    list.add(temp.val);
                }
                result.add(new ArrayList<>(list));
                list.clear();
                linkedList.addLast(null);
                continue;
            }
            if(node.left!=null){
                linkedList.addLast(node.left);
            }
            if(node.right!=null){
                linkedList.addLast(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        new No58Print().Print(root);
    }

}
