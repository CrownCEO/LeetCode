package A_Offer;

import common.TreeNode;

import java.util.*;

/**
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * 解法：
 * 二叉树的层次遍历，设定一个队列，初始只有根结点。循环判断队列是否为空，如果队列不为空，循环取出队列中的值，放入到list 中，
 * 然后将取出的每个结点的左右结点放入到队列中。
 * @author Mr.Bao
 * @create 2019-02-17-18:05
 * @since 1.0.0
 */
public class No23BinaryTreeLevelOrderTraversal {

    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for(int i = 0;i<length;i++){
                TreeNode treeNode =  queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new No23BinaryTreeLevelOrderTraversal().levelOrder(root));
    }

}
