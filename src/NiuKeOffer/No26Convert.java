package NiuKeOffer;

import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-22-16:33
 * @since 1.0.0
 */
public class No26Convert {

    TreeNode head;
    TreeNode tail;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        find(pRootOfTree);
        return head;
    }

    public void find(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            find(node.left);
        }
        createList(node);
        if(node.right!=null) {
            find(node.right);
        }
    }

    public void createList(TreeNode node){
        node.left = tail;
        if(tail!=null){
            tail.right = node;
        }else{
            head = node;
        }
        tail = node;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new No26Convert().Convert(root);
        System.out.println("end");
    }
}
